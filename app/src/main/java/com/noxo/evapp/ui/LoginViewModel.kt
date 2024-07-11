package com.noxo.evapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.noxo.evapp.model.Credentials
import com.noxo.evapp.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val evService: UserRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(LoginState(false, inProgress = false, Credentials("")))
    val uiState: StateFlow<LoginState> = _uiState.asStateFlow()

    fun login(username : String, password : String)  {
        viewModelScope.launch {
            _uiState.update { it.copy(inProgress = true) }
            val result = evService.login(username, password)
            result.onSuccess { credentials ->
                _uiState.update { it.copy(loggedIn = true, inProgress = false, credentials = credentials) }
            }
        }
    }
}

data class LoginState(
    val loggedIn : Boolean,
    val inProgress : Boolean,
    val credentials : Credentials
)