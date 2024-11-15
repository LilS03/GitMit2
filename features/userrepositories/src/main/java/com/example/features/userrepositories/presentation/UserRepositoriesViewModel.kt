package com.example.features.userrepositories.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.features.userrepositories.domain.model.Repo
import com.example.features.userrepositories.domain.usecase.GetRepoUseCase
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
    private val getRepoUseCase: GetRepoUseCase
) : ViewModel() {

    private val _repositories = MutableStateFlow<List<Repo>>(emptyList())
    val repositories: StateFlow<List<Repo>> = _repositories

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _repoEffect = MutableSharedFlow<RepoEffect>()
    val repoEffect = _repoEffect.asSharedFlow()

    fun loadRepositories(page: Int, perPage: Int) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                getRepoUseCase(page, perPage).collect {
                    _repositories.value = it
                }
            } catch (e: Exception) {
                _repoEffect.emit(RepoEffect.NavigateToAuth)
            } finally {
                _isLoading.value = false
            }
        }
    }
}