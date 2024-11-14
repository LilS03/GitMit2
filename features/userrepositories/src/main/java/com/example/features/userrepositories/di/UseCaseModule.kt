package com.example.features.userrepositories.di

import com.example.features.userrepositories.domain.usecase.GetRepoUseCase
import com.example.features.userrepositories.domain.usecase.GetRepoUseCaseImpl
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
}