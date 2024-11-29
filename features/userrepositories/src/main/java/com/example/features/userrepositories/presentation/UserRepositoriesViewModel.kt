package com.example.features.userrepositories.presentation

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

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _repoEffect = MutableSharedFlow<RepoEffect>()
    val repoEffect = _repoEffect.asSharedFlow()

    private var currentPage = CURRENT_PAGE

    fun loadRepositories() {
        if (_isLoading.value) return
        _isLoading.value = true
        viewModelScope.launch {
            gitRepository.getRepo(currentPage, PER_PAGE).collect {
                newRepos ->
                    _repositories.value = (_repositories.value + newRepos).distinctBy { it.id }
                    _isLoading.value = false
                    currentPage++
            }
        }
    }
    companion object{
        private const val CURRENT_PAGE = 1
        private const val PER_PAGE = 2
    }
}