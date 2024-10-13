package com.example.authentication.data.utils

import android.content.SharedPreferences
import javax.inject.Inject

class SharedPreferencesHelper @Inject constructor(private val sharedPreferences: SharedPreferences) {
    fun saveToken(token: String){
        val editor = sharedPreferences.edit()
        editor.putString("token", token)
        editor.apply()
    }
}