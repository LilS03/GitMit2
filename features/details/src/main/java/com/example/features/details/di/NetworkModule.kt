package com.example.features.details.di

import com.example.core.data.annotations.TokenRetrofit
import com.example.features.details.data.retrofit.UsersService
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
    fun provideUsersService(@TokenRetrofit retrofit: Retrofit): UsersService =
        retrofit.create(UsersService::class.java)
}