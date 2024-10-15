package com.example.core.data.helper

import android.content.SharedPreferences
import com.example.core.domain.repository.PreferencesRepository
import javax.inject.Inject

class SharedPreferencesHelper @Inject constructor(
    private val sharedPreferences: SharedPreferences
): PreferencesRepository {

    companion object {
        private const val TOKEN_KEY = "token"
    }
    override fun saveToken(token: String) {
        sharedPreferences.edit().putString(TOKEN_KEY, token).apply()
    }
    override fun getToken(): String? {
        return sharedPreferences.getString(TOKEN_KEY, "")
    }
}