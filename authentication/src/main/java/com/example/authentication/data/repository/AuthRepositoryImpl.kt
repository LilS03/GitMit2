package com.example.authentication.data.repository

import com.example.authentication.data.retrofit.AuthRetrofit
import com.example.authentication.data.utils.SharedPreferencesHelper
import com.example.authentication.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    authRetrofit: AuthRetrofit,
    private val sharedPreferencesHelper: SharedPreferencesHelper
):AuthRepository {
    override fun login(token: String) {
        sharedPreferencesHelper.saveToken(token)
    }
}