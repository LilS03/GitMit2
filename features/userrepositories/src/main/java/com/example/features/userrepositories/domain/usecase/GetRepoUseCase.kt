package com.example.features.userrepositories.domain.usecase

import com.example.features.userrepositories.domain.repository.GitRepoRepository
import javax.inject.Inject

fun interface GetRepoUseCase{
    operator fun invoke()
}

class GetRepoUseCaseImpl @Inject constructor(
    private val repository: GitRepoRepository
): GetRepoUseCase{
    override fun invoke() = repository.getRepo()
}