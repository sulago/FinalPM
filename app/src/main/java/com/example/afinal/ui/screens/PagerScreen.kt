package com.example.afinal.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.afinal.data.data_classes.pages
import com.example.afinal.ui.bars.TopBar
import com.example.afinal.ui.pager.PageIndicator
import com.example.afinal.ui.pages.PagerSinglePage

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PagerScreen(
    navController: NavController
){
    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { pages.size }
    )

    Column(
        modifier = Modifier
            .padding(horizontal = 26.dp , vertical = 56.dp)
            .fillMaxSize()
    ) {

        TopBar(navController)

        Spacer(modifier = Modifier.size(128.dp))

        HorizontalPager(
            state = pagerState
        ) {
                index -> PagerSinglePage(page = pages[index])
        }

        Spacer(modifier = Modifier.size(56.dp))

        PageIndicator(
            pagerState = pagerState,
            pageCount = pages.size
        )
    }
}