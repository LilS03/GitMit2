package com.example.core.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserDbModel(
    @PrimaryKey
    val id: Int,
    val login: String,
    val name: String,
    val bio: String
)