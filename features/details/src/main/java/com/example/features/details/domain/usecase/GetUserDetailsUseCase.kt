package com.example.features.details.domain.usecase

import com.example.features.details.domain.model.UserDetails
import com.example.features.details.domain.repository.UserDetailsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

fun interface GetUserDetailsUseCase{
    operator fun invoke(userName: String): Flow<UserDetails?>
}

class GetUserDetailsUseCaseImpl @Inject constructor(
    private val repository: UserDetailsRepository
): GetUserDetailsUseCase {
    override fun invoke(userName: String): Flow<UserDetails?> =
        repository.getUserDetails(userName)
}