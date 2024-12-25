package com.example.features.userrepositories.domain.usecase

import com.example.features.userrepositories.domain.model.Repo
import com.example.features.userrepositories.domain.repository.GitRepoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

fun interface GetRepoUseCase{
    operator fun invoke(page: Int, per_page: Int): Flow<List<Repo>>
}

class GetRepoUseCaseImpl @Inject constructor(
    private val repository: GitRepoRepository
): GetRepoUseCase {
    override fun invoke(page: Int, per_page: Int): Flow<List<Repo>> =
        repository.getRepo(page, per_page)
}