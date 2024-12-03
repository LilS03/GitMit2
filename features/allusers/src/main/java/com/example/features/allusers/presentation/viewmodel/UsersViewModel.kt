package com.example.features.allusers.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.features.allusers.domain.model.User
import com.example.features.allusers.domain.repository.UsersRepository
import com.example.features.allusers.presentation.effect.UserEffect
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val userRepository: UsersRepository
) : ViewModel() {

    private val _repositories = MutableStateFlow<List<User>>(emptyList())
    val repositories: StateFlow<List<User>> = _repositories

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _userEffect = MutableSharedFlow<UserEffect>()
    val userEffect = _userEffect.asSharedFlow()

    private var currentPage = CURRENT_PAGE

    fun loadUsers() {
        if (_isLoading.value) return
        _isLoading.value = true
        viewModelScope.launch {
            userRepository.getUsers(currentPage, PER_PAGE).collect {
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