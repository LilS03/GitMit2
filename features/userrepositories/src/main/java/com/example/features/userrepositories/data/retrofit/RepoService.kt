package com.example.features.userrepositories.data.retrofit

import com.example.core.data.model.RepoDto
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RepoService {
    @GET("users/{user}/repos")
    fun getRepos(
        @Path("user") user: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): Flow<List<RepoDto>>
}