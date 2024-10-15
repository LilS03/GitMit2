package com.example.core.data.repository

import android.content.SharedPreferences
import com.example.core.domain.repository.PreferencesRepository

class SharedPreferencesHelper(
    private val sharedPreferences: SharedPreferences
): PreferencesRepository {

    companion object {
        private const val TOKEN_KEY = "token"
    }
    override fun saveToken(token: String) {
        sharedPreferences.edit().putString(TOKEN_KEY, token).apply()
    }
    override fun getToken(): String? {
        return sharedPreferences.getString(TOKEN_KEY, null)
    }
}