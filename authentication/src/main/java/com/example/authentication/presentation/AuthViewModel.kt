package com.example.authentication.presentation

import androidx.lifecycle.ViewModel
import com.example.authentication.data.retrofit.AuthRetrofit
import com.example.authentication.domain.model.Authentication
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor() : ViewModel() {
    private val _tokenStatus = MutableStateFlow(false)
    val tokenStatus: StateFlow<Boolean> get() = _tokenStatus

    fun checkGitHubToken(token: String) {
        val call = AuthRetrofit.instance.getUser(token)
        call.enqueue(object : Callback<Authentication> {
            override fun onResponse(call: Call<Authentication>, response: Response<Authentication>) {
                _tokenStatus.value = response.isSuccessful
            }

            override fun onFailure(call: Call<Authentication>, t: Throwable) {
                _tokenStatus.value = false
            }
        })
    }
}