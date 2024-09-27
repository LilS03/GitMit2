package com.example.authentication.data.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AuthRetrofit {
    private const val BASE_URL = "https://api.github.com/"

    val instance: GitHubService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(GitHubService::class.java)
    }
}
