package com.example.features.allusers.di

import com.example.core.data.annotations.TokenRetrofit
import com.example.features.allusers.data.retrofit.UsersService
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
    fun provideGitHubService(@TokenRetrofit retrofit: Retrofit): UsersService =
        retrofit.create(UsersService::class.java)
}