package com.example.core.data.di

import com.example.core.domain.repository.PreferencesRepository
import com.example.core.data.repository.PreferencesRepositoryImpl
import com.example.core.data.helper.SharedPreferencesHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PreferencesModule {
    @Singleton
    @Provides
    fun providePreferencesRepository(
        sharedPreferencesHelper: SharedPreferencesHelper
    ): PreferencesRepository {
        return PreferencesRepositoryImpl(sharedPreferencesHelper)
    }
}