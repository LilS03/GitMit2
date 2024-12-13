package com.example.core.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.core.data.database.model.UserDetailsDbModel

@Dao
interface ProfileDao {
    @Query("SELECT * FROM userDetails")
    fun getProfile(): UserDetailsDbModel?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProfile(userDetails: List<UserDetailsDbModel>)
}