package com.example.features.allusers.presentation.effect

sealed class UserEffect {
    data object NavigateToAuth : UserEffect()
}