package com.example.core.data.repository

import com.example.core.data.helper.SharedPreferencesHelper
import com.example.core.domain.repository.PreferencesRepository
import javax.inject.Inject

class PreferencesRepositoryImpl @Inject constructor(
    private val sharedPreferencesHelper: SharedPreferencesHelper
): PreferencesRepository {
    override fun saveToken(token: String) {
        sharedPreferencesHelper.saveToken(token)
    }

    override fun getToken(): String {
        return sharedPreferencesHelper.getToken().orEmpty()
    }
}