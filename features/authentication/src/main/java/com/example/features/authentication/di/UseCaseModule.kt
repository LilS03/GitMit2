package com.example.features.authentication.di

import com.example.features.authentication.domain.usecase.LoginUseCase
import com.example.features.authentication.domain.usecase.LoginUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {
    @Provides
    fun provideLoginUseCase(loginUseCaseImpl: LoginUseCaseImpl): LoginUseCase = loginUseCaseImpl
}