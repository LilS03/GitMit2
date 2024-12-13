package com.example.features.profil.data.retrofit

import com.example.core.data.model.UserDto
import retrofit2.http.GET

interface ProfileService {
    @GET("users")
    suspend fun getProfile(): UserDto
}