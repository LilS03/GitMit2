package com.example.authentication.domain.usecase

import com.example.authentication.domain.repository.AuthRepository

fun interface LoginUseCase{
    operator fun invoke(token: String)
}
class LoginUseCaseImpl(
    private val repository: AuthRepository
): LoginUseCase {
    override fun invoke(token: String) {
        return repository.login(token)
    }
}