package com.example.features.userrepositories.data.repository

import com.example.features.userrepositories.data.retrofit.GitHubServiceForRepos
import com.example.features.userrepositories.domain.model.Repo
import com.example.features.userrepositories.domain.repository.GitRepoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GitRepoRepositoryImpl @Inject constructor(
    private val gitHubServiceForRepos: GitHubServiceForRepos
): GitRepoRepository {
    override fun getRepo(user: String, page: Int, per_page: Int) : Flow<List<Repo>> = flow {
        gitHubServiceForRepos.getRepos(user, page, per_page)
    }
}