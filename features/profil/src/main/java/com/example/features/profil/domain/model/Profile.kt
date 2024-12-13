package com.example.features.profil.domain.model

data class Profile(
    val id: Int,
    val login: String,
    val avatarUrl: String,
    val name: String,
    val followers: Int,
    val following: Int,
    val publicRepos: Int
)
