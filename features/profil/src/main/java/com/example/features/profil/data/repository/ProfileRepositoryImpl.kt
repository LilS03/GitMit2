package com.example.features.profil.data.repository

import com.example.core.data.database.dao.ProfileDao
import com.example.features.profil.data.mappers.mapDbModelToModel
import com.example.features.profil.data.mappers.mapDtoToModel
import com.example.features.profil.data.mappers.mapModelToDBModel
import com.example.features.profil.data.retrofit.ProfileService
import com.example.features.profil.domain.model.Profile
import com.example.features.profil.domain.repository.ProfileRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val profileService: ProfileService,
    private val profileDao: ProfileDao
) : ProfileRepository {
    override fun getProfile(): Flow<Profile?> = flow {
        try {
            val userDto = profileService.getProfile()
            val userDetails = mapDtoToModel(userDto)
            emit(userDetails)
            withContext(Dispatchers.IO) {
                userDetails?.let {
                    val userDb = mapModelToDBModel(it)
                    profileDao.insertProfile(listOf(userDb))
                }
            }
        } catch (e: HttpException) {
            val userDb = profileDao.getProfile()
            val userModel = userDb?.let { mapDbModelToModel(it) }
            emit(userModel)
        } catch (e: Exception) {
            emit(null)
        }
    }
}