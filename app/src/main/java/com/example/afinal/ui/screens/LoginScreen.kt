package com.example.afinal.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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

@Composable
fun LoginScreen(viewModel: AuthenticationViewModel, navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val authState by viewModel.authState.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(value = email, onValueChange = { email = it }, label = { Text("Email") })
        TextField(value = password, onValueChange = { password = it }, label = { Text("Password") }, visualTransformation = PasswordVisualTransformation())

        Button(onClick = {
            viewModel.loginUser(email, password)
        }) {
            Text("Login")
        }

        TextButton(
            onClick = {
                navController.navigate(Graph.USER_OR_DRIVER)
            }
        ) {
            Text(
                text = "Haven't a account? Register"
            )
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
