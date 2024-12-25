package com.example.features.profil.domain.repository

import com.example.features.profil.domain.model.Profile
import kotlinx.coroutines.flow.Flow

interface ProfileRepository {
    fun getProfile(): Flow<Profile?>
}