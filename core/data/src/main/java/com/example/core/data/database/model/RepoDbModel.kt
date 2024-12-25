package com.example.core.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "repository")
data class RepoDbModel(
    @PrimaryKey
    val id: Int,
    val name: String,
    val language: String,
    val visibility: String
)