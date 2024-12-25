package com.example.features.userrepositories.di

import com.example.core.data.annotations.TokenRetrofit
import com.example.features.userrepositories.data.retrofit.RepoService
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
    fun provideGitHubService(@TokenRetrofit retrofit: Retrofit): RepoService =
        retrofit.create(RepoService::class.java)
}