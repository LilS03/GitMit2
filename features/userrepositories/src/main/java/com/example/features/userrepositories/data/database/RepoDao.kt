package com.example.features.userrepositories.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface RepoDao {
    @Query("SELECT * FROM repository")
    fun getRepos(): Flow<List<RepoDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRepo(repoList: List<RepoDbModel>)
}