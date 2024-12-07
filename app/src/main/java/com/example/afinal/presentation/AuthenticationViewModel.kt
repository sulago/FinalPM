package com.example.afinal.presentation

import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.afinal.data.data_classes.User
import com.example.afinal.ui.functions.getUserData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.userProfileChangeRequest
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class AuthenticationViewModel : ViewModel(){
    private val auth = FirebaseAuth.getInstance()

    private val _authState = MutableStateFlow<AuthState>(AuthState.Idle)
    val authState: StateFlow<AuthState> = _authState

    private val _userData = MutableStateFlow<User?>(null)
    val userData: StateFlow<User?> = _userData

    @RequiresApi(35)
    fun registerUser(
        email: String,
        password: String,
        name: String,
        lastname: String,
        phoneNumber: String
    ) {
        viewModelScope.launch {
            _authState.value = AuthState.Loading
            try {
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val user = auth.currentUser
                        val profileUpdates = userProfileChangeRequest {
                            displayName = "$name $lastname"
                        }
                        user?.updateProfile(profileUpdates)?.addOnCompleteListener {
                            if (it.isSuccessful) {
                                val db = FirebaseDatabase.getInstance()

                                val userRef = db.reference.child("users").child(user.uid)

                                val userData = hashMapOf(
                                    "name" to name,
                                    "lastname" to lastname,
                                    "email" to email,
                                    "phone" to phoneNumber
                                )
                                userRef.setValue(userData).addOnCompleteListener { databaseTask ->
                                    if (databaseTask.isSuccessful) {
                                        _authState.value = AuthState.Success("Registration successful")
                                    } else {
                                        _authState.value = AuthState.Error("Failed to save user data: ${databaseTask.exception?.message}")
                                    }
                                }
                            } else {
                                _authState.value = AuthState.Error(it.exception?.message ?: "Failed to update profile")
                            }
                        }
                    } else {
                        _authState.value = AuthState.Error(task.exception?.message ?: "Registration failed")
                    }
                }
            } catch (e: Exception) {
                _authState.value = AuthState.Error(e.message ?: "Unknown error")
            }
        }
    }

    fun fetchUserData(userId: String) {
        viewModelScope.launch {
            getUserData(userId) { user ->
                _userData.value = user
            }
        }
    }

    fun loginUser(email: String, password: String) {
        viewModelScope.launch {
            _authState.value = AuthState.Loading
            try {
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        _authState.value = AuthState.Success("Login successful")
                    } else {
                        _authState.value = AuthState.Error(task.exception?.message ?: "Login failed")
                    }
                }
            } catch (e: Exception) {
                _authState.value = AuthState.Error(e.message ?: "Unknown error")
            }
        }
    }

    sealed class AuthState {
        data object Idle : AuthState()
        data object Loading : AuthState()
        data class Success(val message: String) : AuthState()
        data class Error(val message: String) : AuthState()
    }

}