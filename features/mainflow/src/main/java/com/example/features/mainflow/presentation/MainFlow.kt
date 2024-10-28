package com.example.features.mainflow.presentation
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainFlow() {
    var selectedItemIndex by rememberSaveable { mutableIntStateOf(BottomNavigationScreen.Home.ordinal) }
    val navController = rememberNavController()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            bottomBar = {
                NavigationBar {
                    BottomNavigationScreen.entries.forEachIndexed { index, screen ->
                        NavigationBarItem(
                            selected = selectedItemIndex == index,
                            onClick = {
                                selectedItemIndex = index
                                navController.navigate(screen.name)
                            },
                            label = { Text(text = screen.title) },
                            alwaysShowLabel = true,
                            icon = {
                                BadgedBox(badge = {}) {
                                    Icon(
                                        imageVector = if (index == selectedItemIndex) {
                                            screen.selectedIcon
                                        } else screen.unselectedIcon,
                                        contentDescription = screen.title
                                    )
                                }
                            }
                        )
                    }
                }
            }
        ) {
            NavHost(
                navController = navController,
                startDestination = BottomNavigationScreen.Home.name
            ) {
                composable(BottomNavigationScreen.Home.name) { HomeScreen() }
                composable(BottomNavigationScreen.Users.name) { UsersScreen() }
                composable(BottomNavigationScreen.Profile.name) { ProfileScreen() }
            }
        }
    }
}

@Composable
fun HomeScreen() {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Text(text = "Home Screen")
    }
}

@Composable
fun UsersScreen() {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Text(text = "Users Screen")
    }
}

@Composable
fun ProfileScreen() {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Text(text = "Profile Screen")
    }
}