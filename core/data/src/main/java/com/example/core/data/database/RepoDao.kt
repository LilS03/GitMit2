package com.example.core.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RepoDao {
    @Query("SELECT * FROM repository")
    fun getRepos(): List<RepoDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRepo(repoList: List<RepoDbModel>)
}