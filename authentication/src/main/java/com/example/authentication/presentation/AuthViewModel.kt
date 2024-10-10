package com.example.authentication.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.authentication.data.retrofit.AuthRetrofit
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRetrofit: AuthRetrofit
) : ViewModel() {
    private val _tokenStatus = MutableStateFlow(false)
    val tokenStatus: StateFlow<Boolean> get() = _tokenStatus

    fun checkGitHubToken(token: String) {
        viewModelScope.launch {
            try {
                val response = authRetrofit.instance.getUser(token)
                _tokenStatus.value = response.isSuccessful
            } catch (e: Exception) {
                _tokenStatus.value = false
            }
        }
    }
}