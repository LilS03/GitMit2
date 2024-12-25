package com.example.features.details.data.repository

import com.example.core.data.database.dao.UserDetailsDao
import com.example.features.details.data.mappers.mapDbModelToModel
import com.example.features.details.data.mappers.mapDtoToModel
import com.example.features.details.data.mappers.mapModelToDBModel
import com.example.features.details.data.retrofit.UsersService
import com.example.features.details.domain.model.UserDetails
import com.example.features.details.domain.repository.UserDetailsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import javax.inject.Inject

class UserDetailsRepositoryImpl @Inject constructor(
    private val usersService: UsersService,
    private val userDetailsDao: UserDetailsDao
) : UserDetailsRepository {
    override fun getUserDetails(username: String): Flow<UserDetails?> = flow {
        try {
            val userDto = usersService.getUserDetails(username)
            val userDetails = mapDtoToModel(userDto)
            emit(userDetails)
            withContext(Dispatchers.IO) {
                userDetails?.let {
                    val userDb = mapModelToDBModel(it)
                    userDetailsDao.insertUserDetails(listOf(userDb))
                }
            }
        } catch (e: HttpException) {
            val userDb = userDetailsDao.getUserDetails(username)
            val userModel = userDb?.let { mapDbModelToModel(it) }
            emit(userModel)

        } catch (e: Exception) {
            emit(null)
        }
    }
}