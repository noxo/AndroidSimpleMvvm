package com.noxo.evapp.repository

import com.noxo.evapp.model.Station

interface EVStationRepository {
    suspend fun getStations(token : String, latitude : Double, longitude: Double) : Result<Array<Station>>
}