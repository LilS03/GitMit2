package com.example.authentication.domain.usecase

import com.example.authentication.domain.repository.AuthRepository

class LogoutUseCase(
    private val repository: AuthRepository
) {
    fun logout() {
        return repository.logout()
    }
}