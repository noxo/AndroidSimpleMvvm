package com.noxo.evapp.service

import com.noxo.evapp.model.Credentials
import com.noxo.evapp.model.Station

interface EvService {
    suspend fun login(username : String, password : String) : Credentials
    suspend fun getStations(token : String, latitude : Double, longitude: Double) : Array<Station>
}