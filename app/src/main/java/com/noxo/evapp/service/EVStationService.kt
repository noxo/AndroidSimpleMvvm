package com.noxo.evapp.service

import com.noxo.evapp.model.Station

interface EVStationService {
    suspend fun getStations(
        token: String,
        latitude: Double,
        longitude: Double
    ): Result<Array<Station>>
}