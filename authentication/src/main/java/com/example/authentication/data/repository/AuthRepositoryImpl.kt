package com.example.authentication.data.repository

import com.example.authentication.data.utils.SharedPreferencesHelper
import com.example.authentication.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val sharedPreferencesHelper: SharedPreferencesHelper
):AuthRepository {
    override fun login(token: String) {
        sharedPreferencesHelper.saveToken(token)
    }
    override fun getToken(): String? {
        return sharedPreferencesHelper.getToken()
    }
    override fun exit(){
        return sharedPreferencesHelper.clearToken()
    }
}