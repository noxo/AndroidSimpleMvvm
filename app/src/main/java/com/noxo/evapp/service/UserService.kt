package com.noxo.evapp.service

import com.noxo.evapp.model.Credentials

interface UserService {
    suspend fun authenticate(username : String, password : String) : Result<Credentials>
}