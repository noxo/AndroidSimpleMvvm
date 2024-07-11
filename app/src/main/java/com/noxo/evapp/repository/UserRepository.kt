package com.noxo.evapp.repository

import com.noxo.evapp.model.Credentials

interface UserRepository {
    suspend fun login(username : String, password : String) : Result<Credentials>
}