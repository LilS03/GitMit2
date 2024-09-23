package com.example.authentication.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.authentication.domain.repository.AuthRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class AuthViewModel(
    application: Application,
    private val repository: AuthRepository
) : AndroidViewModel(application) {
    private val token = repository.getToken()
    val login = token?.let { repository.login(it) }
}