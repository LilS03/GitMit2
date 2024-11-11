package com.example.core.data.di

import android.app.Application
import androidx.room.Room
import com.example.core.data.database.AppDatabase
import com.example.core.data.database.RepoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    fun provideDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(app, AppDatabase::class.java, "AppDatabase").build()
    }

    @Provides
    fun provideRepositoryDao(db: AppDatabase): RepoDao {
        return db.repoDao()
    }
}
