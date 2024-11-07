package com.example.features.authentication.data.retrofit

import com.example.core.data.model.UserDto
import retrofit2.http.GET
import retrofit2.http.Header

interface AuthApi {
    @GET("user")
    suspend fun getUser(@Header("Authorization") token: String): UserDto
}