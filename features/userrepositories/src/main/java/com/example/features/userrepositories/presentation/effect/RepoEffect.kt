package com.example.features.userrepositories.presentation.effect

sealed class RepoEffect {
    data object NavigateToAuth : RepoEffect()
}