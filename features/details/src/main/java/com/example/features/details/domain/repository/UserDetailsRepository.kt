package com.example.features.details.domain.repository

import com.example.features.details.domain.model.UserDetails
import kotlinx.coroutines.flow.Flow

interface UserDetailsRepository {
    fun getUserDetails(userName: String): Flow<UserDetails?>
}