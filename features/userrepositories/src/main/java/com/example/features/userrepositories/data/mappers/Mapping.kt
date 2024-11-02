package com.example.features.userrepositories.data.mappers

import com.example.core.data.model.RepoDto
import com.example.features.userrepositories.domain.model.Repo

fun mapDtoToModel(repoDto: RepoDto): Repo =
    Repo(
        name = repoDto.name,
        language = repoDto.language,
        visibility = repoDto.visibility
    )