// /Users/noxo/git/AndroidSimpleMvvm/app/src/main/java/com/noxo/evapp/service/FakeEVStationService.kt
package com.noxo.evapp.service

import android.content.Context
import com.google.gson.Gson
import com.noxo.evapp.R
import com.noxo.evapp.model.Station

class FakeEVStationService(
    private val context: Context
) : EVStationService {

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