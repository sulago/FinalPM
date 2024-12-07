package com.example.afinal.nav

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.afinal.data.data_classes.BottomGraph
@Composable
fun BottomNavigationBar(
    navController: NavController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar(
        tonalElevation = 0.dp,
        modifier = Modifier
            .height(80.dp)
            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 56.dp)
        ) {
            BottomGraph.BottomNavItems.forEach { navItem ->
                NavigationBarItem(
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .size(50.dp),
                    selected = currentRoute == navItem.route,
                    onClick = {
                        navController.navigate(navItem.route) {
                            launchSingleTop = true
                        }
                    },
                    icon = {
                        val tintColor = if (currentRoute == navItem.route) {
                            androidx.compose.ui.graphics.Color.Green
                        } else {
                            androidx.compose.ui.graphics.Color.Gray
                        }
                        Icon(
                            painter = painterResource(navItem.icon),
                            contentDescription = null,
                            tint = tintColor,
                            modifier = Modifier.size(25.dp)
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = androidx.compose.ui.graphics.Color(0xFF6200EE),
                        unselectedIconColor = androidx.compose.ui.graphics.Color.Gray,
                        indicatorColor = androidx.compose.ui.graphics.Color.Transparent
                    )
                )
            }
        }
    }
}