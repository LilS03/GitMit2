package com.example.features.allusers.data.retrofit

import com.example.core.data.model.UserDto
import retrofit2.http.GET
import retrofit2.http.Query

interface UsersService {
    @GET("users")
    suspend fun getUsers(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): List<UserDto>
}