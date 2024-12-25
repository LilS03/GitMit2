package com.example.features.mainflow.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.features.allusers.presentation.Screen
import com.example.features.allusers.presentation.UsersScreen
import com.example.features.details.presentation.UserDetailsScreen
import com.example.features.profil.presentation.ProfileScreen
import com.example.features.userrepositories.presentation.RepoScreen

@Composable
fun MainFlow() {
    val navController = rememberNavController()
    val currentBackStackEntry by navController.currentBackStackEntryAsState()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            bottomBar = {
                NavigationBar {
                    BottomNavigationScreen.values().forEach { screen ->
                        val isSelected = currentBackStackEntry?.destination?.route == screen.route
                        NavigationBarItem(
                            selected = isSelected,
                            onClick = {
                                if (!isSelected) {
                                    navController.navigate(screen.route) {
                                        popUpTo(navController.graph.startDestinationId) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                }
                            },
                            label = {
                                Text(
                                    text = stringResource(id = screen.title),
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                                )
                            },
                            alwaysShowLabel = true,
                            icon = {
                                BadgedBox(badge = {}) {
                                    Icon(
                                        imageVector = if (isSelected) screen.selectedIcon else screen.unselectedIcon,
                                        contentDescription = stringResource(id = screen.title)
                                    )
                                }
                            }
                        )
                    }
                }
            }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = Screen.Home.route,
                modifier = Modifier.padding(innerPadding)
            ) {
                composable(Screen.Home.route) { RepoScreen() }
                composable(Screen.Users.route) { UsersScreen(navController) }
                composable(Screen.Profile.route) { ProfileScreen() }
                composable(Screen.UserDetails.route) { backStackEntry ->
                    val username = backStackEntry.arguments?.getString("username")
                    if (username != null) {
                        UserDetailsScreen(username)
                    }
                }
            }
        }
    }
}