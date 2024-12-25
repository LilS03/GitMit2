package com.example.features.userrepositories.di

import com.example.features.userrepositories.domain.usecase.GetRepoUseCase
import com.example.features.userrepositories.domain.usecase.GetRepoUseCaseImpl
import com.example.features.userrepositories.domain.usecase.GetUserReposUseCase
import com.example.features.userrepositories.domain.usecase.GetUserReposUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {
    @Provides
    @ViewModelScoped
    fun provideGetRepoUseCase(getRepoUseCaseImpl: GetRepoUseCaseImpl): GetRepoUseCase =
        getRepoUseCaseImpl
    @Provides
    @ViewModelScoped
    fun provideGetUserRepoUseCase(getUserRepoUseCaseImpl: GetUserReposUseCaseImpl): GetUserReposUseCase =
        getUserRepoUseCaseImpl
}