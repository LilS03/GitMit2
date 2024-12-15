package com.example.features.userrepositories.domain.repository

import com.example.features.userrepositories.domain.model.Repo
import kotlinx.coroutines.flow.Flow

interface GitRepoRepository {
    fun getRepo(page: Int, per_page: Int): Flow<List<Repo>>
    fun getUserRepos(username: String, page: Int, per_page: Int): Flow<List<Repo>>
}