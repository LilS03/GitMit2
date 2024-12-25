package com.example.core.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.core.data.database.dao.ProfileDao
import com.example.core.data.database.dao.RepoDao
import com.example.core.data.database.dao.UserDao
import com.example.core.data.database.dao.UserDetailsDao
import com.example.core.data.database.model.RepoDbModel
import com.example.core.data.database.model.UserDbModel
import com.example.core.data.database.model.UserDetailsDbModel

@Database(
    entities = [RepoDbModel::class, UserDbModel::class, UserDetailsDbModel::class],
    version = 2,
    exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun repoDao(): RepoDao
    abstract fun userDao(): UserDao
    abstract fun userDetailsDao(): UserDetailsDao
    abstract fun profileDao(): ProfileDao
}