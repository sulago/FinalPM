package com.example.afinal.data.data_classes

import androidx.annotation.DrawableRes
import com.example.afinal.R
import com.example.afinal.nav.Graph

data class BottomNavItem(
    @DrawableRes val icon: Int,
    val route:String,
)

object BottomGraph {
    val BottomNavItems = listOf(
        BottomNavItem(
            icon = R.drawable.ic_home,
            route = Graph.HOME
        ),
        BottomNavItem(
            icon = R.drawable.ic_partner,
            route = Graph.PARTNER
        ),
        BottomNavItem(
            icon = R.drawable.ic_about,
            route = Graph.ABOUT
        )
    )
}