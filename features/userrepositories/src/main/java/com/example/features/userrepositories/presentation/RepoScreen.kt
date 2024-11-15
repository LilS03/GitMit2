package com.example.features.userrepositories.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.features.userrepositories.presentation.effect.RepoEffect

@Composable
fun RepoScreen(
    navigateToAuth: () -> Unit = {},
    viewModel: UserRepositoriesViewModel = hiltViewModel()
) {
    val repositories = viewModel.repositories.collectAsState()
    val isLoading = viewModel.isLoading.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.repoEffect.collect { effect ->
            when (effect) {
                is RepoEffect.NavigateToAuth -> navigateToAuth()
            }
        }
    }

    LaunchedEffect(Unit) {
        viewModel.loadRepositories(1, 30)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        when {
            isLoading.value -> {
                CircularProgressIndicator()
            }
            repositories.value.isEmpty() -> {
                Text(text = "No repositories found")
            }
            else -> {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(repositories.value) { repo ->
                        Text(text = repo.name, modifier = Modifier.padding(8.dp))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowScreenPreview() {
    RepoScreen()
}