package com.example.features.details.data.mappers

import com.example.core.data.database.model.UserDetailsDbModel
import com.example.core.data.model.UserDto
import com.example.features.details.domain.model.UserDetails


fun mapDtoToModel(userDetailsDto: UserDto): UserDetails? =
    userDetailsDto.id?.let {
        UserDetails(
            id = it,
            login = userDetailsDto.login.orEmpty(),
            avatarUrl = userDetailsDto.avatarUrl.orEmpty(),
            name = userDetailsDto.name.orEmpty(),
            followers = userDetailsDto.followers,
            following = userDetailsDto.following,
            publicRepos = userDetailsDto.publicRepos
        )
    }

fun mapModelToDBModel(userDetails: UserDetails): UserDetailsDbModel =
    UserDetailsDbModel(
        id = userDetails.id,
        login = userDetails.login,
        avatar_url = userDetails.avatarUrl,
        name = userDetails.name,
        followers = userDetails.followers,
        following = userDetails.following,
        publicRepos = userDetails.publicRepos
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

fun mapDbModelToModel(dbModel: UserDetailsDbModel): UserDetails =
    UserDetails(
        id = dbModel.id,
        login = dbModel.login,
        avatarUrl = dbModel.avatar_url,
        name = dbModel.name,
        followers = dbModel.followers,
        following = dbModel.following,
        publicRepos = dbModel.publicRepos
    )