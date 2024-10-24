package com.example.features.authentication.presentation.effect

sealed class AuthEffect {
    data object NavigateToMain : AuthEffect()
}