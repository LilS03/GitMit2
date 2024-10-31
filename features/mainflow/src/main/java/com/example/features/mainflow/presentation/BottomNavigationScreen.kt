package com.example.features.mainflow.presentation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.features.mainflow.R

enum class BottomNavigationScreen(
    @StringRes val title: Int,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val route: String
) {
    Home(
        title = R.string.homeScreen,
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
        route = "home"
    ),
    Users(
        title = R.string.usersScreen,
        selectedIcon = Icons.Filled.Menu,
        unselectedIcon = Icons.Outlined.Menu,
        route = "users"
    ),
    Profile(
        title = R.string.profileScreen,
        selectedIcon = Icons.Filled.Person,
        unselectedIcon = Icons.Outlined.Person,
        route = "profile"
    )
}