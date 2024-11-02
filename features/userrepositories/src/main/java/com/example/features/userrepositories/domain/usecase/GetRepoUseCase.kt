package com.example.features.userrepositories.domain.usecase

import com.example.features.userrepositories.domain.model.Repo
import com.example.features.userrepositories.domain.repository.GitRepoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

fun interface GetRepoUseCase{
    operator fun invoke(name: String, page: Int, per_page: Int): Flow<List<Repo>>
}

class GetRepoUseCaseImpl @Inject constructor(
    private val repository: GitRepoRepository
): GetRepoUseCase{
    override fun invoke(name: String, page: Int, per_page: Int)
        = repository.getRepo(name, page, per_page)
}