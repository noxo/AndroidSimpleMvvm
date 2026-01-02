package com.noxo.evapp.repository

import com.noxo.evapp.model.Station
import com.noxo.evapp.service.EVStationService

class EVStationRepositoryImpl(
    private val service: EVStationService
) : EVStationRepository {
    override suspend fun getStations(
        token: String,
        latitude: Double,
        longitude: Double
    ): Result<Array<Station>> {
        return service.getStations(token,latitude,longitude)
    }
}