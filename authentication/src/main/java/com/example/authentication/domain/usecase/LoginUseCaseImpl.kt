package com.example.authentication.domain.usecase

import com.example.authentication.domain.repository.AuthRepository
import com.example.core.data.dispatcher.GitDispatchers
import com.example.core.data.repository.SharedPreferencesHelper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

fun interface LoginUseCase{
    operator fun invoke(token: String): Flow<Boolean>
}
class LoginUseCaseImpl @Inject constructor(
    private val repository: AuthRepository,
    private val preferenceRepository: SharedPreferencesHelper,
    private val dispatcher: GitDispatchers
): LoginUseCase {
    override fun invoke(token: String): Flow<Boolean> = repository.checkToken(token)
        .map { isValid ->
            if (isValid) {
                preferenceRepository.saveToken(token)
            } else {
                preferenceRepository.saveToken("")
            }
            isValid
        }
        .flowOn(dispatcher.ioDispatcher)
}