package com.example.features.profil.di

import com.example.core.data.annotations.TokenRetrofit
import com.example.features.profil.data.retrofit.ProfileService
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
    fun provideProfileService(@TokenRetrofit retrofit: Retrofit): ProfileService =
        retrofit.create(ProfileService::class.java)
}