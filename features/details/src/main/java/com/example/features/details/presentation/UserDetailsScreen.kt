package com.example.features.details.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.features.details.R
import com.example.features.details.presentation.viewmodel.UserDetailsViewModel
import com.example.features.userrepositories.presentation.Repo

@Composable
fun UserDetailsScreen(
    username: String,
    viewModel: UserDetailsViewModel = hiltViewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.loadUserDetails(username)
    }

    val userDetails by viewModel.userDetails.collectAsState()
    val userRepositories by viewModel.userRepositories.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val listState = rememberLazyListState()

    LaunchedEffect(listState) {
        snapshotFlow { listState.layoutInfo.visibleItemsInfo }.collect {
            listState.interactionSource.interactions.collect {
                viewModel.loadUserRepos(username)
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        userDetails?.let { user ->
            val painter = rememberAsyncImagePainter(model = user.avatarUrl)
            Image(
                painter = painter,
                contentDescription = user.name,
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
            )
            Text(text = user.name)
            Text(text = user.login)
            Text(text = stringResource(id = R.string.followers) + user.followers)
            Text(text = stringResource(id = R.string.following) + user.following)
            Text(text = stringResource(id = R.string.publicRepos) + user.publicRepos)

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = stringResource(id = R.string.userRepositories))
            if (userRepositories.isEmpty() && !isLoading) {
                Text(text = stringResource(id = R.string.noRepos))
            } else {
                LazyColumn(
                    state = listState,
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(userRepositories) { repo ->
                        Repo(repo)
                    }
                    item {
                        if (isLoading) {
                            Text(stringResource(id = R.string.loading))
                            CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
                        }
                    }
                }
            }
        } ?: run {
            CircularProgressIndicator()
        }
    }
}
