package com.example.core.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.core.data.database.model.UserDbModel

@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    fun getUsers(): List<UserDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(userList: List<UserDbModel>)
}