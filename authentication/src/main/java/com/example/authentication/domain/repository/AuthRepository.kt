package com.example.authentication.domain.repository

import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun checkToken(token: String): Flow<Boolean>
}