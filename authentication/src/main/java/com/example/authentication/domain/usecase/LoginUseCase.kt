package com.example.authentication.domain.usecase

import com.example.authentication.domain.repository.AuthRepository

class LoginUseCase(
    private val repository: AuthRepository
){
    fun login(token: String) {
        return repository.login(token)
    }
}