package com.example.authentication.domain.usecase

import com.example.authentication.domain.repository.AuthRepository

class GetTokenUseCase(
    private val repository: AuthRepository
) {
    fun getToken(): String? {
        return repository.getToken()
    }
}