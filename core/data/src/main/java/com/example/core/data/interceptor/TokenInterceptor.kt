package com.example.core.data.interceptor

import com.example.core.domain.repository.PreferencesRepository
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class TokenInterceptor @Inject constructor(
    private val preferencesRepository: PreferencesRepository,
): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val token = preferencesRepository.getToken()

        if (token.isEmpty()) {
            return chain.proceed(originalRequest)
        }

        val modifiedRequest = originalRequest.newBuilder()
            .header("Authorization", "Bearer $token")
            .build()

        return chain.proceed(modifiedRequest)
    }
}