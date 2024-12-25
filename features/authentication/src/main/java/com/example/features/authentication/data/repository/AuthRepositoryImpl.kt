package com.example.features.authentication.data.repository

import com.example.features.authentication.data.retrofit.AuthApi
import com.example.features.authentication.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authApi: AuthApi
):AuthRepository {
    override fun checkToken(token: String): Flow<Boolean> = flow {
            authApi.getUser("Bearer $token")
            emit(true)
    }.catch {
        emit(false)
    }
}