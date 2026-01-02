package com.noxo.evapp.repository

import com.noxo.evapp.model.Credentials
import com.noxo.evapp.service.UserService


class UserRepositoryImpl(
    private val service: UserService
) : UserRepository {

    override suspend fun login(username: String, password: String): Result<Credentials> {
        return service.authenticate(username, password)
    }
}