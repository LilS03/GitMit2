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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
            contentDescription = stringResource(id = R.string.logo),
            modifier = Modifier.size(100.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = token,
            onValueChange = { authViewModel.changeToken(it) },
            label = { Text(stringResource(id = R.string.enterToken)) }
        )
        Spacer(modifier = Modifier.height(16.dp))
        if(!isTokenValid){
            Text(
                text = stringResource(id = R.string.invalidToken),
                color = MaterialTheme.colorScheme.error
            )
        }
        Button(onClick = {
            authViewModel.checkGitHubToken()
        }) {
            Text(stringResource(id = R.string.logIn))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowScreen(){
    AuthScreen()
}