package com.example.features.details.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.features.details.domain.model.UserDetails
import com.example.features.details.domain.repository.UserDetailsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserDetailsViewModel @Inject constructor(
    private val repository: UserDetailsRepository
) : ViewModel() {

    private val _userDetails = MutableStateFlow<UserDetails?>(null)
    val userDetails: StateFlow<UserDetails?> get() = _userDetails

    fun loadUserDetails(username: String) {
        viewModelScope.launch {
            repository.getUserDetails(username).collect { userDetails ->
                _userDetails.value = userDetails
            }
        }
    }
}
