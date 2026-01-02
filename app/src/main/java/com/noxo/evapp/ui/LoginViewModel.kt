package com.noxo.evapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.noxo.evapp.navigation.NavigationRoutes
import com.noxo.evapp.navigation.NavigationManager
import com.noxo.evapp.repository.AuthRepository
import com.noxo.evapp.repository.UserRepository
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel (
    private val userRepository: UserRepository,
    private val navigationManager: NavigationManager,
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(LoginState(false, inProgress = false))
    val uiState: StateFlow<LoginState> = _uiState.asStateFlow()

    fun login(username : String, password : String)  {
        viewModelScope.launch {
            _uiState.update { it.copy(inProgress = true) }
            val result = userRepository.login(username, password)
            result.onSuccess { credentials ->
                authRepository.setAuthToken(credentials.token)
                _uiState.update { it.copy(loggedIn = true, inProgress = false) }
                navigationManager.navigate(NavigationRoutes.stations)
            }
        }
    }
}

data class LoginState(
    val loggedIn : Boolean,
    val inProgress : Boolean
)