package com.example.features.userrepositories.di

import com.example.features.userrepositories.domain.repository.GitRepoRepository
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
    fun provideGitRepoRepository(
        gitRepoRepositoryImpl: GitRepoRepository
    ): GitRepoRepository = gitRepoRepositoryImpl
}