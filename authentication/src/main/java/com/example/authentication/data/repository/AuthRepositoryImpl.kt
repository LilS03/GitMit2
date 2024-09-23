package com.example.authentication.data.repository

import android.content.Context
import com.example.authentication.data.utils.SharedPreferencesHelper
import com.example.authentication.domain.repository.AuthRepository

class AuthRepositoryImpl(context: Context):AuthRepository {

    private val sharedPreferencesHelper = SharedPreferencesHelper(context)

    override fun login(token: String) {
        sharedPreferencesHelper.saveToken(token)
    }

    override fun getToken(): String? {
        return sharedPreferencesHelper.getToken()
    }
}
