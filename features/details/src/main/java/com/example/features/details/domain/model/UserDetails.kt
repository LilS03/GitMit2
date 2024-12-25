package com.example.features.details.domain.model

data class UserDetails(
    val id: Int,
    val login: String,
    val avatarUrl: String,
    val name: String,
    val followers: Int,
    val following: Int,
    val publicRepos: Int
)
