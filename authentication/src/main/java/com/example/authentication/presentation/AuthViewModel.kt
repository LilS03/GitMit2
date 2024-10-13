package com.example.authentication.presentation

import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.authentication.domain.usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {
    private val _isTokenValid = MutableStateFlow(true)
    val isTokenValid: StateFlow<Boolean> get() = _isTokenValid.asStateFlow()

    private val _token = MutableStateFlow("")
    val token: StateFlow<String> get() = _token.asStateFlow()

    fun checkGitHubToken() {
        loginUseCase(token.value).onEach { isValid ->
            _isTokenValid.update { isValid }
            sharedFlow.emit(AuthEffect.NavigateToMain)
        }.catch {
            _isTokenValid.update { false }
        }.launchIn(viewModelScope)
    }

    fun changeToken(token: String) {
        _token.update { token }
        _isTokenValid.update { true }
    }
}
