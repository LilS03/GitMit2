package com.example.features.allusers.di

import com.example.features.allusers.domain.usecase.GetUsersUseCase
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
    fun provideGetUsersUseCase(getUsersUseCaseImpl: GetUsersUseCase): GetUsersUseCase =
        getUsersUseCaseImpl
}