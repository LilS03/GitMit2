package com.example.features.allusers.data.mappers

import com.example.core.data.database.model.UserDbModel
import com.example.core.data.model.UserDto
import com.example.features.allusers.domain.model.User

fun mapDtoToModel(userDto: UserDto): User? =
    userDto.id?.let {
        User(
            id = it,
            login = userDto.login,
            name = userDto.name,
            bio = userDto.bio
        )
    }

fun mapModelToDBModel(user: User): UserDbModel =
    UserDbModel(
        id = user.id,
        login = user.login,
        name = user.name,
        bio = user.bio
    )

fun mapDtoToDBModel(userDto: UserDto): UserDbModel? =
    userDto.id?.let {
        UserDbModel(
            id = it,
            login = userDto.login,
            name = userDto.name,
            bio = userDto.bio
        )
    }

fun mapDbModelToModel(dbModel: UserDbModel): User =
    User(
        id = dbModel.id,
        login = dbModel.login,
        name = dbModel.name,
        bio = dbModel.bio
    )