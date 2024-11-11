package com.example.core.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [RepoDbModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun repoDao(): RepoDao
}