package com.example.features.userrepositories.presentation

import androidx.lifecycle.ViewModel
import com.example.features.userrepositories.domain.model.Repo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

@HiltViewModel
class UserRepositoriesViewModel @Inject constructor() : ViewModel() {

    private val _repositories = MutableSharedFlow<List<Repo>>()
    val repositories = _repositories.asSharedFlow()
}