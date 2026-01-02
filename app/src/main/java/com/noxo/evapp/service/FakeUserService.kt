package com.noxo.evapp.service

import android.content.Context
import com.google.gson.Gson
import com.noxo.evapp.R
import com.noxo.evapp.model.Credentials
import kotlinx.coroutines.delay

class FakeUserService (
    private val context: Context
) : UserService  {

    private inline fun <reified T> getJson(jsonResource : Int): T {
        val json = context.resources.openRawResource(jsonResource).bufferedReader().use {
            it.readText()
        }
        return Gson().fromJson(json, T::class.java)
    }

    override suspend fun authenticate(username: String, password: String): Result<Credentials> {
        delay(2000)
        return Result.success(getJson(R.raw.login))
    }

}