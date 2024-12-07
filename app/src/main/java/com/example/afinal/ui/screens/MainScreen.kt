package com.example.afinal.ui.screens

import android.annotation.SuppressLint
import androidx.annotation.RequiresApi
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.afinal.nav.BottomNavigationBar
import com.example.afinal.nav.Graph
import com.example.afinal.nav.Navigation
import com.example.afinal.presentation.AuthenticationViewModel

@RequiresApi(35)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(){
    val viewModel: AuthenticationViewModel = viewModel()

    val navController = rememberNavController()
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route

    val excludedRoutes = listOf(
        Graph.ROOT,
        Graph.LOGIN,
        Graph.REGISTER,
        Graph.USER_OR_DRIVER
    )

    Scaffold(
        bottomBar = {
            if (currentRoute != null && currentRoute !in excludedRoutes){
                BottomNavigationBar(navController)
            }
        }
    ){
        Navigation(viewModel, navController)
    }
}