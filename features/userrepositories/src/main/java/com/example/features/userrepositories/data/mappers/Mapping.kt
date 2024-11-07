package com.example.features.userrepositories.data.mappers

import com.example.core.data.model.RepoDto
import com.example.features.userrepositories.data.database.RepoDbModel
import com.example.features.userrepositories.domain.model.Repo

fun mapDtoToModel(repoDto: RepoDto): Repo =
    Repo(
        name = repoDto.name,
        language = repoDto.language,
        visibility = repoDto.visibility
    )
fun mapDtoToDBModel(repoDto: RepoDto): RepoDbModel =
    RepoDbModel(
        name = repoDto.name,
        language = repoDto.language,
        visibility = repoDto.visibility
    )
fun mapDbModelToModel(dbModel: RepoDbModel): Repo =
    Repo(
        name = dbModel.name,
        language = dbModel.language,
        visibility = dbModel.visibility
    )