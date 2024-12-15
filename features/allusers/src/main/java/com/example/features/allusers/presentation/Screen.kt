package com.example.features.allusers.presentation

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object Users : Screen("users")
    data object Profile : Screen("profile")
    data object UserDetails : Screen("userDetails/{username}") {
        fun createRoute(username: String) = "userDetails/$username"
    }
}