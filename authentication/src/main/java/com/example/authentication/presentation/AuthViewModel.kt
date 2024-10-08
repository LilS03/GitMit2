package com.example.authentication.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.authentication.data.retrofit.AuthRetrofit
import com.example.authentication.domain.model.Authentication
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor() : ViewModel() {
    private val _tokenStatus = MutableLiveData<Boolean>()
    val tokenStatus: LiveData<Boolean> get() = _tokenStatus

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