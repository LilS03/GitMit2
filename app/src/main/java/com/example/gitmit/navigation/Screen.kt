package com.example.gitmit.navigation

sealed class Screen(val route: String) {
    data object AuthScreen: Screen("auth")
}