package com.example.features.profil.domain.usecase

import com.example.features.profil.domain.model.Profile
import com.example.features.profil.domain.repository.ProfileRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

fun interface GetProfileUseCase{
    operator fun invoke(): Flow<Profile?>
}

class GetProfileUseCaseImpl @Inject constructor(
    private val repository: ProfileRepository
): GetProfileUseCase {
    override fun invoke(): Flow<Profile?> =
        repository.getProfile()
}