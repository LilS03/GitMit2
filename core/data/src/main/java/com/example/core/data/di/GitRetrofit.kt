package com.example.core.data.di

import com.example.core.data.interceptor.HeaderInterceptor
import com.google.android.datatransport.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object GitRetrofit {

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        loggingInterceptor: HttpLoggingInterceptor,
        headerInterceptor: HeaderInterceptor
    ): Retrofit {
        val okHttpClientBuilder = OkHttpClient.Builder()
            .addInterceptor(headerInterceptor)
        if (BuildConfig.DEBUG) {
            okHttpClientBuilder.addInterceptor(loggingInterceptor)
        }
        val okHttpClient = okHttpClientBuilder.build()
        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}