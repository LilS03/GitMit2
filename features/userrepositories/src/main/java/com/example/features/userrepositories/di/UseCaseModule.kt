package com.example.features.userrepositories.di

import com.example.features.userrepositories.domain.usecase.GetRepoUseCase
import com.example.features.userrepositories.domain.usecase.GetRepoUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {
    @Provides
    fun provideGetRepoUseCase(getRepoUseCaseImpl: GetRepoUseCaseImpl): GetRepoUseCase = getRepoUseCaseImpl
}