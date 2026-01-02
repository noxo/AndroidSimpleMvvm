package com.noxo.evapp.repository

import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    val authToken: Flow<String?>
    suspend fun setAuthToken(token: String)
}