package com.example.core.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.core.data.database.dao.RepoDao
import com.example.core.data.database.model.RepoDbModel

@Database(entities = [RepoDbModel::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun repoDao(): RepoDao
}