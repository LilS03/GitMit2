package com.example.authentication.di

import com.example.authentication.data.repository.AuthRepositoryImpl
import com.example.authentication.data.retrofit.AuthRetrofit
import com.example.authentication.data.utils.SharedPreferencesHelper
import com.example.authentication.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideAuthRepository(
        authRetrofit: AuthRetrofit,
        sharedPreferencesHelper: SharedPreferencesHelper
    ): AuthRepository {
        return AuthRepositoryImpl(authRetrofit, sharedPreferencesHelper)
    }
}