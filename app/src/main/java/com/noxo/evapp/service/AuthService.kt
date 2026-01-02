package com.noxo.evapp.service
import kotlinx.coroutines.flow.Flow

interface AuthService {
    val authTokenFlow: Flow<String?>
    suspend fun persistAuthToken(token: String)
}