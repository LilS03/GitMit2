package com.example.core.data.helper

import android.content.SharedPreferences
import javax.inject.Inject

class SharedPreferencesHelper @Inject constructor(
    private val sharedPreferences: SharedPreferences
){

    companion object {
        private const val TOKEN_KEY = "token"
    }
    fun saveToken(token: String) =
        sharedPreferences.edit().putString(TOKEN_KEY, token).apply()

    fun getToken(): String? =
        sharedPreferences.getString(TOKEN_KEY, "")
}