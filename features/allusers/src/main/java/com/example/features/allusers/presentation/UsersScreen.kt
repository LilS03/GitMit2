package com.example.features.allusers.presentation

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
import com.example.features.allusers.R
import com.example.features.allusers.presentation.effect.UserEffect
import com.example.features.allusers.presentation.viewmodel.UsersViewModel


@Composable
fun UsersScreen(
    navigateToAuth: () -> Unit = {},
    viewModel: UsersViewModel = hiltViewModel()
) {
    val repositories by viewModel.repositories.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val listState = rememberLazyListState()

    LaunchedEffect(Unit) {
        viewModel.userEffect.collect { effect ->
            when (effect) {
                is UserEffect.NavigateToAuth -> navigateToAuth()
            }
        }
    }

    LaunchedEffect(Unit) {
        viewModel.loadUsers()
    }

    LaunchedEffect(listState) {
        snapshotFlow { listState.layoutInfo.visibleItemsInfo }.collect {
            listState.interactionSource.interactions.collect {
                viewModel.loadUsers()
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
        Text(stringResource(id = R.string.users))
        when {
            isLoading && repositories.isEmpty() -> {
                CircularProgressIndicator()
            }

            repositories.isEmpty() -> {
                Text(stringResource(id = R.string.noUsers))
            }

            else -> {
                LazyColumn(
                    state = listState,
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(repositories) { user ->
                        User(user)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowScreenPreview() {
    UsersScreen()
}

