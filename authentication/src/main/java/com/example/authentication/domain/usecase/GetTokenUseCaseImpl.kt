package com.example.authentication.domain.usecase

import com.example.authentication.domain.repository.AuthRepository

fun interface GetTokenUseCase{
    operator fun invoke(): String?
}
class GetTokenUseCaseImpl(
    private val repository: AuthRepository
): GetTokenUseCase {
    override fun invoke(): String? {
        return repository.getToken()
    }
}