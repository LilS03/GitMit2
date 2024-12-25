package com.example.features.allusers.domain.repository

import com.example.features.allusers.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UsersRepository {
    fun getUsers(page: Int, per_page: Int): Flow<List<User>>
}