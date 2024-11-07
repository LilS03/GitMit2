package com.example.features.userrepositories.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "repository")
data class RepoDbModel(
    @PrimaryKey
    val name: String,
    val language: String,
    val visibility: String
)