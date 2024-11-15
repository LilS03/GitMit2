package com.example.features.userrepositories.data.repository

import com.example.core.data.database.RepoDao
import com.example.features.userrepositories.data.mappers.mapDtoToModel
import com.example.features.userrepositories.data.mappers.mapModelToDBModel
import com.example.features.userrepositories.data.retrofit.RepoService
import com.example.features.userrepositories.domain.model.Repo
import com.example.features.userrepositories.domain.repository.GitRepoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class GitRepoRepositoryImpl @Inject constructor(
    private val repoService: RepoService
) : GitRepoRepository {
    override fun getRepo(page: Int, per_page: Int): Flow<List<Repo>> = flow {
        try {
            val repoDtoList = repoService.getRepos(page, per_page)
            val repoModels = repoDtoList.mapNotNull { mapDtoToModel(it) }
            emit(repoModels)
        } catch (e: HttpException) {
            emit(emptyList())
        } catch (e: Exception) {
            emit(emptyList())
        }
    }
}