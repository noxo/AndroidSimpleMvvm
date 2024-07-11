package com.noxo.evapp.repository

import android.content.Context
import com.google.gson.Gson
import com.noxo.evapp.R
import com.noxo.evapp.model.Station
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

class FakeEVStationRepository  @Inject constructor(
    @ActivityContext private val context: Context
): EVStationRepository {

    private inline fun <reified T> getJson(jsonResource : Int): T {
        val json = context.resources.openRawResource(jsonResource).bufferedReader().use {
            it.readText()
        }
        return Gson().fromJson(json, T::class.java)
    }

    override suspend fun getStations(
        token: String,
        latitude: Double,
        longitude: Double
    ): Result<Array<Station>> {
        return Result.success(getJson(R.raw.stations))
    }

}