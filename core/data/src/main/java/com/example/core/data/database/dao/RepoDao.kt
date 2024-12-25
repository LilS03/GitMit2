package com.example.core.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.core.data.database.model.RepoDbModel

@Dao
interface RepoDao {
    @Query("SELECT * FROM repository")
    fun getRepos(): List<RepoDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRepo(repoList: List<RepoDbModel>)
}