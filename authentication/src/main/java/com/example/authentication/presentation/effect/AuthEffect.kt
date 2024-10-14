package com.example.authentication.presentation.effect

sealed class AuthEffect {
    data object NavigateToMain : AuthEffect()
    data class ShowError(val message: String) : AuthEffect()
}
