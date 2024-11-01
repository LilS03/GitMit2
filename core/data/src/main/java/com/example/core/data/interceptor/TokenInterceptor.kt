package com.example.core.data.interceptor

import com.example.core.data.helper.SharedPreferencesHelper
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class TokenInterceptor @Inject constructor(
    private val sharedPreferencesHelper: SharedPreferencesHelper
): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val token = sharedPreferencesHelper.getToken()

        if (token.isNullOrEmpty()) {
            return chain.proceed(originalRequest)
        }

        val modifiedRequest = originalRequest.newBuilder()
            .addHeader("Authorization", "Bearer $token")
            .build()

        return chain.proceed(modifiedRequest)
    }
}