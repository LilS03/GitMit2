package com.example.authentication.data.retrofit

import com.example.authentication.data.model.UserDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface GitHubService {
    @GET("user")
    suspend fun getUser(@Header("Authorization") token: String): UserDto
}
