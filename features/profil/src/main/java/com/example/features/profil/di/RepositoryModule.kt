package com.example.features.profil.di

import com.example.features.profil.data.repository.ProfileRepositoryImpl
import com.example.features.profil.domain.repository.ProfileRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindUsersRepository(
        profileRepositoryImpl: ProfileRepositoryImpl
    ): ProfileRepository
}