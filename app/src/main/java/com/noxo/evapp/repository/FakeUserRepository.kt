package com.noxo.evapp.repository

import android.content.Context
import com.google.gson.Gson
import com.noxo.evapp.R
import com.noxo.evapp.model.Credentials
import dagger.hilt.android.qualifiers.ActivityContext
import kotlinx.coroutines.delay
import javax.inject.Inject

class FakeUserRepository @Inject constructor(
    @ActivityContext private val context: Context
): UserRepository {

    private inline fun <reified T> getJson(jsonResource : Int): T {
        val json = context.resources.openRawResource(jsonResource).bufferedReader().use {
            it.readText()
        }
        return Gson().fromJson(json, T::class.java)
    }

    override suspend fun login(username: String, password: String): Result<Credentials> {
        delay(2000)
        return Result.success(getJson(R.raw.login))
    }


}