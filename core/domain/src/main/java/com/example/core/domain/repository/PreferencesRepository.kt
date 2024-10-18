package com.example.core.domain.repository

interface PreferencesRepository {
    fun saveToken(token: String)
    fun getToken(): String?
}