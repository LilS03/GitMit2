package com.example.features.allusers.data.repository

import com.example.core.data.database.dao.UserDao
import com.example.features.allusers.data.mappers.mapDbModelToModel
import com.example.features.allusers.data.mappers.mapDtoToModel
import com.example.features.allusers.data.mappers.mapModelToDBModel
import com.example.features.allusers.data.retrofit.UsersService
import com.example.features.allusers.domain.model.User
import com.example.features.allusers.domain.repository.UsersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(
    private val usersService: UsersService,
    private val userDao: UserDao
) : UsersRepository {
    override fun getUsers(page: Int, per_page: Int): Flow<List<User>> = flow {
        try {
            val usersDtoList = usersService.getUsers(page, per_page)
            val usersModels = usersDtoList.mapNotNull { mapDtoToModel(it) }
            emit(usersModels)
            withContext(Dispatchers.IO) {
                val userDb = usersModels.map { mapModelToDBModel(it) }
                userDao.insertUser(userDb)
            }
        } catch (e: HttpException) {
            if(e.code() == 401){
                val userDb = userDao.getUsers()
                val userModel = userDb.map { mapDbModelToModel(it) }
                emit(userModel)
            }
        } catch (e: Exception) {
            emit(emptyList())
        }
    }
}