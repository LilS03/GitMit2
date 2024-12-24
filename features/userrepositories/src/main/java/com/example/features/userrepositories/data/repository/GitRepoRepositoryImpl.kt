package com.example.features.userrepositories.data.repository

import com.example.core.data.database.dao.RepoDao
import com.example.features.userrepositories.data.mappers.mapDbModelToModel
import com.example.features.userrepositories.data.mappers.mapDtoToModel
import com.example.features.userrepositories.data.mappers.mapModelToDBModel
import com.example.features.userrepositories.data.retrofit.RepoService
import com.example.features.userrepositories.domain.model.Repo
import com.example.features.userrepositories.domain.repository.GitRepoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import javax.inject.Inject

class GitRepoRepositoryImpl @Inject constructor(
    private val repoService: RepoService,
    private val repoDao: RepoDao
) : GitRepoRepository {
    override fun getRepo(page: Int, per_page: Int): Flow<List<Repo>> = flow {
        try {
            val repoDtoList = repoService.getRepos(page, per_page)
            val repoModels = repoDtoList.mapNotNull { mapDtoToModel(it) }
            emit(repoModels)
            withContext(Dispatchers.IO) {
                val repoDb = repoModels.map { mapModelToDBModel(it) }
                repoDao.insertRepo(repoDb)
            }
        } catch (e: HttpException) {
            val repoDb = repoDao.getRepos()
            val repoModel = repoDb.map { mapDbModelToModel(it) }
            emit(repoModel)

        } catch (e: Exception) {
            emit(emptyList())
        }
    }

    override fun getUserRepos(username: String, page: Int, per_page: Int): Flow<List<Repo>> = flow {
        val userRepos = repoService.getUserRepos(username, page, per_page)
        val user = userRepos.mapNotNull { mapDtoToModel(it) }
        emit(user)
    }
}
