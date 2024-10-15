package com.example.authentication.di

import com.example.authentication.domain.usecase.LoginUseCase
import com.example.authentication.domain.usecase.LoginUseCaseImpl
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