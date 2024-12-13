package com.example.core.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.core.data.database.model.UserDetailsDbModel

@Dao
interface UserDetailsDao {
    @Query("SELECT * FROM userDetails WHERE login = :username")
    fun getUserDetails(username: String): UserDetailsDbModel?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUserDetails(userDetails: List<UserDetailsDbModel>)
}
