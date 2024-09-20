package com.example.authentication.domain.usecase

import com.example.authentication.domain.repository.AuthRepository

class LoginUseCase(
    private val repository: AuthRepository
): AuthRepository {
    override fun login(token: String): Boolean {
        return repository.login(token)
    }
}