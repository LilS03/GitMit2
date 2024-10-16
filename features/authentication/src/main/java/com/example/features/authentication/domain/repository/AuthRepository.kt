package com.example.features.authentication.domain.repository

import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun checkToken(token: String): Flow<Boolean>
}