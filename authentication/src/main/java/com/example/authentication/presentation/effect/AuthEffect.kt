package com.example.authentication.presentation.effect

sealed class AuthEffect {
    data object NavigateToMain : AuthEffect()
}
