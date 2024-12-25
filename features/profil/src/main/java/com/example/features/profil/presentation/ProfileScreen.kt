package com.example.features.profil.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.features.profil.R
import com.example.features.profil.presentation.viewmodel.ProfileViewModel

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = hiltViewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.loadProfile()
    }

    val profile by viewModel.profile.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        profile?.let { user ->
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
        } ?: run {
            CircularProgressIndicator()
        }
    }

}