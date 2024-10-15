package com.example.authentication.data.repository

import com.example.authentication.data.retrofit.GitHubService
import com.example.authentication.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val gitHubService: GitHubService
):AuthRepository {
    override fun checkToken(token: String): Flow<Boolean> = flow {
            gitHubService.getUser("Bearer $token")
            emit(true)
    }.catch {
        emit(false)
    }
}