package com.example.features.userrepositories.data.retrofit

import com.example.core.data.model.RepoDto
import retrofit2.http.GET

interface GitHubServiceForRepos {
    @GET("users/{user}/repos")
    suspend fun getRepo(): List<RepoDto>
}