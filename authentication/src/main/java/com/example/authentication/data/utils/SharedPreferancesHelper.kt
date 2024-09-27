package com.example.authentication.data.utils

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

class SharedPreferencesHelper @Inject constructor(context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)

    fun saveToken(token: String) {
        val editor = sharedPreferences.edit()
        editor.putString("token", token)
        editor.apply()
    }

    fun getToken(): String? {
        return sharedPreferences.getString("token", null)
    }

    fun clearToken() {
        val editor = sharedPreferences.edit()
        editor.remove("token")
        editor.apply()
    }
}
