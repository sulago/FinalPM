package com.example.afinal.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.afinal.presentation.AuthenticationViewModel
import com.google.firebase.auth.FirebaseAuth
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: AuthenticationViewModel
){
    val user = viewModel.userData.collectAsState().value

    val userId = FirebaseAuth.getInstance().currentUser?.uid

    if (userId != null) {
        if (user == null) {
            viewModel.fetchUserData(userId)
        }

        user?.let {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text("Welcome, ${it.name} ${it.lastname}!")
                Text("Email: ${it.email}")
                Text("Phone: ${it.phone}")
            }
        }
    } else {
        Text("User not logged in")
    }
}