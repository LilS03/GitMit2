package com.example.features.authentication.di

import com.example.core.data.annotations.NoTokenRetrofit
import com.example.features.authentication.data.retrofit.AuthApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideGitHubService(@NoTokenRetrofit retrofit: Retrofit): AuthApi =
        retrofit.create(AuthApi::class.java)
}