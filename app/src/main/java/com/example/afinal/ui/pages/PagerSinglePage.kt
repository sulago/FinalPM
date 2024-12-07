package com.example.afinal.ui.pages


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.afinal.data.data_classes.Page


@Composable
fun PagerSinglePage(
    page: Page
){
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ){
        Image(
            painter = painterResource(page.image),
            contentDescription = page.image.toString()
        )

        Spacer(modifier = Modifier.size(72.dp))

        Text(
            text = page.text,
            fontSize = 32.sp,
            fontWeight = FontWeight.Normal
        )

    }
}