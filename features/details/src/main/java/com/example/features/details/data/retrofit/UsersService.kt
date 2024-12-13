package com.example.features.details.data.retrofit

import com.example.core.data.model.UserDto
import retrofit2.http.GET
import retrofit2.http.Path

interface UsersService {
    @GET("users/{username}")
    suspend fun getUserDetails(
        @Path("username") username: String
    ): UserDto
}