package com.example.afinal.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.afinal.nav.Graph
import com.example.afinal.ui.bars.TopBarDriverOrUser

@Composable
fun UserOrDriver(navController: NavController){
    Column(
        modifier = Modifier
            .padding(horizontal = 26.dp , vertical = 56.dp)
            .fillMaxSize()
    ){
        TopBarDriverOrUser(navController)

        Spacer(Modifier.size(64.dp))

        Button(
            onClick = {
                navController.navigate(Graph.REGISTER)
            }
        ) {
            Text(
                text = "USER"
            )
        }

        Spacer(Modifier.size(16.dp))

        Button(
            onClick = {
                navController.navigate(Graph.REGISTER)
            }
        ) {
            Text(
                text = "Driver"
            )
        }
    }
}