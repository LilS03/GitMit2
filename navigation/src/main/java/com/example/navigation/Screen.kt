package com.example.navigation

sealed class Screen(val route: String) {
    data object AuthScreen: Screen("authentication")
}