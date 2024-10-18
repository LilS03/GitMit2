package com.example.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.features.authentication.presentation.AuthScreen

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.AuthScreen.route) {
        composable(route = Screen.AuthScreen.route){
            AuthScreen(navigateToMainScreen = {
                navController.popBackStack()
                navController.navigate(Screen.MainScreen.route)
            })
        }
        composable(route = Screen.MainScreen.route) {
            //MainScreen()
        }
    }
}