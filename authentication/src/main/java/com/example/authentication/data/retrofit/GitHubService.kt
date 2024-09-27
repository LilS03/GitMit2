package com.example.authentication.data.retrofit

import com.example.authentication.domain.model.Authentication
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface GitHubService {
    @GET("user")
    fun getUser(@Header("Authorization") token: String): Call<Authentication>
}
