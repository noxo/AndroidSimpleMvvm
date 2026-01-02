package com.noxo.evapp.repository

import com.noxo.evapp.service.AuthService
import kotlinx.coroutines.flow.Flow

class AuthRepositoryImpl(
    private val service: AuthService
) : AuthRepository {
    override val authToken: Flow<String?> = service.authTokenFlow
    override suspend fun setAuthToken(token: String) = service.persistAuthToken(token)
}