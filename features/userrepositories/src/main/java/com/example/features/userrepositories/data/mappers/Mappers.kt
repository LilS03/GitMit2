package com.example.features.userrepositories.data.mappers

import com.example.core.data.database.model.RepoDbModel
import com.example.core.data.model.RepoDto
import com.example.features.userrepositories.domain.model.Repo

fun mapDtoToModel(repoDto: RepoDto): Repo? =
    repoDto.id?.let {
        Repo(
        id = it,
        name = repoDto.name.orEmpty(),
        language = repoDto.language.orEmpty(),
        visibility = repoDto.visibility.orEmpty()
    )
    }

fun mapModelToDBModel(repo: Repo): RepoDbModel =
    RepoDbModel(
        id = repo.id,
        name = repo.name,
        language = repo.language,
        visibility = repo.visibility
    )

fun mapDtoToDBModel(repoDto: RepoDto): RepoDbModel? =
    repoDto.id?.let {
        RepoDbModel(
            id = it,
            name = repoDto.name.orEmpty(),
            language = repoDto.language.orEmpty(),
            visibility = repoDto.visibility.orEmpty()
        )
    }

fun mapDbModelToModel(dbModel: RepoDbModel): Repo =
    Repo(
        id = dbModel.id,
        name = dbModel.name,
        language = dbModel.language,
        visibility = dbModel.visibility
    )
