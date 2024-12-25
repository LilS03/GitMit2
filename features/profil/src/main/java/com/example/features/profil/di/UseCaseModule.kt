package com.example.features.profil.di

import com.example.features.profil.domain.usecase.GetProfileUseCase
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
    fun provideGetProfileUseCase(getProfileUseCaseImpl: GetProfileUseCase): GetProfileUseCase =
        getProfileUseCaseImpl
}