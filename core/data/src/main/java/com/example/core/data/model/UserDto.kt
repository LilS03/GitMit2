package com.example.core.data.model
import com.google.gson.annotations.SerializedName

data class UserDto(
    @SerializedName("login") val login: String,
    @SerializedName("avatar_url") val avatarUrl: String,
    @SerializedName("name") val name: String,
    @SerializedName("bio") val bio: String,
    @SerializedName("public_repos") val publicRepos: Int,
    @SerializedName("public_gists") val publicGists: Int,
    @SerializedName("followers") val followers: Int,
    @SerializedName("following") val following: Int
)