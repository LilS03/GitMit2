package com.example.features.details.di

import com.example.features.details.data.repository.UserDetailsRepositoryImpl
import com.example.features.details.domain.repository.UserDetailsRepository
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
        usersRepositoryImpl: UserDetailsRepositoryImpl
    ): UserDetailsRepository
}