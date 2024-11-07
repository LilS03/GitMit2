package com.example.features.userrepositories.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RepoDbModel::class], version = 1, exportSchema = false)
abstract class RepoDatabase : RoomDatabase() {
    companion object {

        private var db: RepoDatabase? = null
        private const val DB_NAME = "repo.db"
        private val LOCK = Any()

        fun getInstance(context: Context): RepoDatabase {
            synchronized(LOCK) {
                db?.let { return it }
                val instance =
                    Room.databaseBuilder(
                        context,
                        RepoDatabase::class.java,
                        DB_NAME
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                db = instance
                return instance
            }
        }
    }

    abstract fun repoDao(): RepoDao
}
