package com.example.afinal.ui.bars

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.afinal.nav.Graph

@Composable
fun TopBar(navController: NavController){
    Row (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            text = "Birge",
            fontSize = 24.sp,
            fontWeight = FontWeight.Light,
            color = Color.Green
        )

        Text(
            modifier = Modifier
                .clickable {
                    navController.navigate(Graph.LOGIN)
                },
            text = "Skip",
            fontSize = 16.sp,
            fontWeight = FontWeight.Light,
            color = Color.LightGray
        )
    }
}