package com.example.core.data.di

import android.content.Context
import androidx.room.Room
import com.example.core.data.database.AppDatabase
import com.example.core.data.database.dao.RepoDao
import com.example.core.data.database.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app_database.db"
        ).fallbackToDestructiveMigration().build()

    @Singleton
    @Provides
    fun provideRepoDao(database: AppDatabase): RepoDao =
        database.repoDao()

    @Singleton
    @Provides
    fun provideUserDao(database: AppDatabase): UserDao =
        database.userDao()
}