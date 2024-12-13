package com.example.core.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userDetails")
data class UserDetailsDbModel(
    @PrimaryKey
    val id: Int,
    val login: String,
    val avatar_url: String,
    val name: String,
    val followers: Int,
    val following: Int,
    val publicRepos: Int
)