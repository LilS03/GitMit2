package com.example.features.authentication.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.features.authentication.R
import com.example.features.authentication.presentation.effect.AuthEffect

@Composable
fun AuthScreen(
    navigateToMainScreen: () -> Unit = {},
    authViewModel: AuthViewModel = hiltViewModel()
) {
    val token by authViewModel.token.collectAsState()
    val isTokenValid by authViewModel.isTokenValid.collectAsState()

    LaunchedEffect(Unit) {
        authViewModel.authEffect.collect { effect ->
            when (effect) {
                is AuthEffect.NavigateToMain -> navigateToMainScreen()
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_logo),
            contentDescription = R.string.logo.toString(),
            modifier = Modifier.size(100.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = token,
            onValueChange = { authViewModel.changeToken(it) },
            label = { Text(R.string.enterToken.toString()) }
        )
        Spacer(modifier = Modifier.height(16.dp))
        if(!isTokenValid){
            Text(
                text = R.string.invalidToken.toString(),
                color = Color.Red
            )
        }
        Button(onClick = {
            authViewModel.checkGitHubToken()
        }) {
            Text(R.string.logIn.toString())
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowScreen(){
    AuthScreen()
}