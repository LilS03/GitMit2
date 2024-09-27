package com.example.authentication.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.authentication.data.retrofit.AuthRetrofit
import com.example.authentication.domain.model.Authentication
import com.example.authentication.domain.repository.AuthRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class AuthViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {
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

    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                // Get the Application object from extras
                val application = checkNotNull(extras[APPLICATION_KEY])

                return AuthViewModel(
                    (application as AuthViewModel).repository
                ) as T
            }
        }
    }
}