package com.example.core.data.model

import com.google.gson.annotations.SerializedName

data class RepoDto(
    @SerializedName("name") val name: String,
    @SerializedName("language") val language: String,
    @SerializedName("visibility") val visibility: String,
)