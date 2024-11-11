package com.example.features.userrepositories.data.repository

import com.example.features.userrepositories.data.mappers.mapDtoToModel
import com.example.features.userrepositories.data.retrofit.RepoService
import com.example.features.userrepositories.domain.model.Repo
import com.example.features.userrepositories.domain.repository.GitRepoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GitRepoRepositoryImpl @Inject constructor(
    private val repoService: RepoService
) : GitRepoRepository {
    override fun getRepo(user: String, page: Int, per_page: Int): Flow<List<Repo>> = flow {
        val repoDto = repoService.getRepos(user, page, per_page)
        val repo = repoDto.map { ::mapDtoToModel }

    }
}