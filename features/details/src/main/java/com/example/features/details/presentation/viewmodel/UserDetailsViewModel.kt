package com.example.features.details.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.features.details.domain.model.UserDetails
import com.example.features.details.domain.repository.UserDetailsRepository
import com.example.features.userrepositories.domain.model.Repo
import com.example.features.userrepositories.domain.repository.GitRepoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserDetailsViewModel @Inject constructor(
    private val userDetailsRepository: UserDetailsRepository,
    private val userRepositoriesRepository: GitRepoRepository
) : ViewModel() {

    private val _userDetails = MutableStateFlow<UserDetails?>(null)
    val userDetails: StateFlow<UserDetails?> get() = _userDetails

    private val _userRepositories = MutableStateFlow<List<Repo>>(emptyList())
    val userRepositories: StateFlow<List<Repo>> get() = _userRepositories

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> get() = _isLoading

    private var currentPage = CURRENT_PAGE

    fun loadUserDetails(username: String) {
        viewModelScope.launch {
            userDetailsRepository.getUserDetails(username).collect { userDetails ->
                _userDetails.value = userDetails
            }
        }
        loadUserRepos(username)
    }

    fun loadUserRepos(username: String) {
        if (_isLoading.value) return
        _isLoading.value = true
        viewModelScope.launch {
            userRepositoriesRepository.getUserRepos(username, currentPage, PER_PAGE).collect { newRepos ->
                _userRepositories.value = (_userRepositories.value + newRepos).distinctBy { it.id }
                _isLoading.value = false
                currentPage++
            }
        }
    }

    companion object {
        private const val CURRENT_PAGE = 1
        private const val PER_PAGE = 2
    }
}