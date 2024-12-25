package com.example.features.userrepositories.domain.usecase

import com.example.features.userrepositories.domain.model.Repo
import com.example.features.userrepositories.domain.repository.GitRepoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

fun interface GetUserReposUseCase{
    operator fun invoke(username: String, page: Int, per_page: Int): Flow<List<Repo>>
}

class GetUserReposUseCaseImpl @Inject constructor(
    private val repository: GitRepoRepository
): GetUserReposUseCase {
    override fun invoke(username: String, page: Int, per_page: Int): Flow<List<Repo>> =
        repository.getUserRepos(username, page, per_page)
}