package com.example.afinal.ui.screens

import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.afinal.nav.Graph
import com.example.afinal.presentation.AuthenticationViewModel

@RequiresApi(35)
@Composable
fun RegisterScreen(viewModel: AuthenticationViewModel, navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var lastname by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }

    val authState by viewModel.authState.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(value = name, onValueChange = { name = it }, label = { Text("Name") })
        TextField(value = lastname, onValueChange = { lastname = it }, label = { Text("Last Name") })
        TextField(value = email, onValueChange = { email = it }, label = { Text("Email") })
        TextField(value = password, onValueChange = { password = it }, label = { Text("Password") }, visualTransformation = PasswordVisualTransformation())
        TextField(value = phoneNumber, onValueChange = { phoneNumber = it }, label = { Text("Phone Number") })

        Button(onClick = {
            viewModel.registerUser(email, password, name, lastname, phoneNumber)
        }) {
            Text("Register")
        }

        when (authState) {
            is AuthenticationViewModel.AuthState.Loading -> CircularProgressIndicator()
            is AuthenticationViewModel.AuthState.Success -> {
                Text((authState as AuthenticationViewModel.AuthState.Success).message)
                navController.navigate(Graph.HOME)
            }
            is AuthenticationViewModel.AuthState.Error -> Text((authState as AuthenticationViewModel.AuthState.Error).message, color = Color.Red)
            else -> {}
        }
    }
}
