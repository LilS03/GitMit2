package com.example.features.userrepositories.di

import com.example.features.userrepositories.data.repository.GitRepoRepositoryImpl
import com.example.features.userrepositories.domain.repository.GitRepoRepository
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
    abstract fun bindGitRepoRepository(
        gitRepoRepositoryImpl: GitRepoRepositoryImpl
    ): GitRepoRepository
}