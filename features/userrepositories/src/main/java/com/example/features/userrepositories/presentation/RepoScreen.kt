package com.example.features.userrepositories.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.features.userrepositories.R
import com.example.features.userrepositories.presentation.effect.RepoEffect

@Composable
fun RepoScreen(
    navigateToAuth: () -> Unit = {},
    viewModel: UserRepositoriesViewModel = hiltViewModel()
) {
    val repositories by viewModel.repositories.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val listState = rememberLazyListState()

    LaunchedEffect(Unit) {
        viewModel.repoEffect.collect { effect ->
            when (effect) {
                is RepoEffect.NavigateToAuth -> navigateToAuth()
            }
        }
    }

    LaunchedEffect(Unit) {
        viewModel.loadRepositories()
    }

    LaunchedEffect(listState) {
        snapshotFlow { listState.layoutInfo.visibleItemsInfo }.collect {
            listState.interactionSource.interactions.collect {
                viewModel.loadRepositories()
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
        Text(stringResource(id = R.string.repos))
        when {
            isLoading && repositories.isEmpty() -> {
                CircularProgressIndicator()
            }

            repositories.isEmpty() -> {
                Text(stringResource(id = R.string.noRepos))
            }

            else -> {
                LazyColumn(
                    state = listState,
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(repositories) { repo ->
                        Repo(repo)
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
