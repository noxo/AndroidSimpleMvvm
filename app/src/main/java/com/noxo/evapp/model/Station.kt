package com.noxo.evapp.model

data class Station(
    val city: String,
    val evses: List<Evse>,
    val id: Int,
    val latitude: Double,
    val longitude: Double,
    val name: String,
    val provider: String
)