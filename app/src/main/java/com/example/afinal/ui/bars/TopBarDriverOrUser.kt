package com.example.afinal.ui.bars

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun TopBarDriverOrUser(navController: NavController){
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ){
        Text(
            text = "Birge",
            fontSize = 24.sp,
            fontWeight = FontWeight.Light,
            color = Color.Green
        )
    }
}