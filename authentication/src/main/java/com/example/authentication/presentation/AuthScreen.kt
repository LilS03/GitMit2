package com.example.authentication.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.authentication.R

@Composable
fun AuthScreen(
    navigateOnSignOut: () -> Unit = {},
    authViewModel: AuthViewModel = hiltViewModel()
) {
    var token by remember { mutableStateOf("") }
    val tokenStatus by authViewModel.tokenStatus.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.baseline_logo),
            contentDescription = "Logo",
            modifier = Modifier.size(100.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = token,
            onValueChange = { token = it },
            label = { Text("Enter Token") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            authViewModel.checkGitHubToken(token)
        }) {
            Text("Connect")
        }
        tokenStatus.let { isSuccess ->
            if (isSuccess) {
                navigateOnSignOut()
            } else {
                Text("Invalid token, please try again.")
            }
        }
    }
}