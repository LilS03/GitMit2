package com.example.features.allusers.domain.usecase

import com.example.features.allusers.domain.model.User
import com.example.features.allusers.domain.repository.UsersRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

fun interface GetUsersUseCase{
    operator fun invoke(page: Int, per_page: Int): Flow<List<User>>
}

class GetUsersUseCaseImpl @Inject constructor(
    private val repository: UsersRepository
): GetUsersUseCase {
    override fun invoke(page: Int, per_page: Int): Flow<List<User>> =
        repository.getUsers(page, per_page)
}