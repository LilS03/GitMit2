package com.example.features.profil.data.mappers

import com.example.core.data.database.model.UserDetailsDbModel
import com.example.core.data.model.UserDto
import com.example.features.profil.domain.model.Profile


fun mapDtoToModel(userDetailsDto: UserDto): Profile? =
    userDetailsDto.id?.let {
        Profile(
            id = it,
            login = userDetailsDto.login.orEmpty(),
            avatarUrl = userDetailsDto.avatarUrl.orEmpty(),
            name = userDetailsDto.name.orEmpty(),
            followers = userDetailsDto.followers,
            following = userDetailsDto.following,
            publicRepos = userDetailsDto.publicRepos
        )
    }

fun mapModelToDBModel(profile: Profile): UserDetailsDbModel =
    UserDetailsDbModel(
        id = profile.id,
        login = profile.login,
        avatar_url = profile.avatarUrl,
        name = profile.name,
        followers = profile.followers,
        following = profile.following,
        publicRepos = profile.publicRepos
    )

fun mapDtoToDBModel(userDetailsDto: UserDto): UserDetailsDbModel? =
    userDetailsDto.id?.let {
        UserDetailsDbModel(
            id = it,
            login = userDetailsDto.login.orEmpty(),
            avatar_url = userDetailsDto.avatarUrl.orEmpty(),
            name = userDetailsDto.name.orEmpty(),
            followers = userDetailsDto.followers,
            following = userDetailsDto.following,
            publicRepos = userDetailsDto.publicRepos
        )
    }

fun mapDbModelToModel(dbModel: UserDetailsDbModel): Profile =
    Profile(
        id = dbModel.id,
        login = dbModel.login,
        avatarUrl = dbModel.avatar_url,
        name = dbModel.name,
        followers = dbModel.followers,
        following = dbModel.following,
        publicRepos = dbModel.publicRepos
    )