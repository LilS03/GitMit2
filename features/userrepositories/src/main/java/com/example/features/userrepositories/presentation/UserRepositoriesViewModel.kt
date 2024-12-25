package com.example.features.userrepositories.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.features.userrepositories.domain.model.Repo
import com.example.features.userrepositories.domain.repository.GitRepoRepository
import com.example.features.userrepositories.presentation.effect.RepoEffect
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserRepositoriesViewModel @Inject constructor(
    private val gitRepository: GitRepoRepository
) : ViewModel() {

    private val _repositories = MutableStateFlow<List<Repo>>(emptyList())
    val repositories: StateFlow<List<Repo>> = _repositories
    var canPaginate by mutableStateOf(false)

    private val _repoEffect = MutableSharedFlow<RepoEffect>()
    val repoEffect = _repoEffect.asSharedFlow()

    private var currentPage = CURRENT_PAGE

    init {
        loadRepositories()
    }

     fun loadRepositories() = viewModelScope.launch {
        if (currentPage == 1 || canPaginate) {
            gitRepository.getRepo(currentPage, PER_PAGE).collect { newRepos ->
                canPaginate = newRepos.size == PER_PAGE
                _repositories.value = (_repositories.value + newRepos).distinctBy { it.id }
                if (canPaginate)
                    currentPage++
            }
        }
    }

    companion object {
        private const val CURRENT_PAGE = 1
        private const val PER_PAGE = 2
    }
}