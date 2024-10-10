package com.example.authentication.domain.usecase

import com.example.authentication.domain.repository.AuthRepository

fun interface ExitUseCase {
    operator fun invoke()
}
class ExitUseCaseImpl(
    private val repository: AuthRepository
) : ExitUseCase {
    override fun invoke(){
        return repository.exit()
    }
}