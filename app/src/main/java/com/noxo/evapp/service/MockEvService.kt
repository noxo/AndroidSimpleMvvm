package com.noxo.evapp.service

import android.content.Context
import com.google.gson.Gson
import com.noxo.evapp.R
import com.noxo.evapp.model.Credentials
import com.noxo.evapp.model.Station
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

class MockEvService @Inject constructor(
    @ActivityContext private val context: Context
): EvService {

    private inline fun <reified T> getJson(jsonResource : Int): T {
        val json = context.resources.openRawResource(jsonResource).bufferedReader().use {
            it.readText()
        }
        return Gson().fromJson(json, T::class.java)
    }

    override suspend fun login(username: String, password: String): Credentials {
       return getJson(R.raw.login)
    }

    override suspend fun getStations(
        token: String,
        latitude: Double,
        longitude: Double
    ): Array<Station> {
        return getJson(R.raw.stations)
    }

}