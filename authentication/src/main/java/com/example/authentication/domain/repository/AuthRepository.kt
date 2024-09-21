package com.example.authentication.domain.repository

interface AuthRepository {
    fun login(token: String)
    fun logout()
    fun getToken(): String?
}