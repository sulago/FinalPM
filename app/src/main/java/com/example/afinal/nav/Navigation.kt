package com.example.afinal.nav

import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.afinal.presentation.AuthenticationViewModel
import com.example.afinal.ui.screens.AboutScreen
import com.example.afinal.ui.screens.HomeScreen
import com.example.afinal.ui.screens.LoginScreen
import com.example.afinal.ui.screens.PagerScreen
import com.example.afinal.ui.screens.PartnerScreen
import com.example.afinal.ui.screens.RegisterScreen
import com.example.afinal.ui.screens.UserOrDriver

@RequiresApi(35)
@Composable
fun Navigation(viewModel: AuthenticationViewModel , navController: NavHostController){
    NavHost(navController = navController, startDestination = Graph.ROOT , builder = {
        composable(Graph.ROOT){
            PagerScreen(navController)
        }
        composable(Graph.HOME){
            HomeScreen(navController, viewModel)
        }
        composable(Graph.LOGIN){
            LoginScreen(viewModel , navController)
        }
        composable(Graph.REGISTER){
            RegisterScreen(viewModel , navController)
        }
        composable(Graph.ABOUT){
            AboutScreen(navController)
        }
        composable(Graph.PARTNER){
            PartnerScreen(navController)
        }
        composable(Graph.USER_OR_DRIVER){
            UserOrDriver(navController)
        }
    })
}