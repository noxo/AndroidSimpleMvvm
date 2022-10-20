package com.noxo.evapp.model

data class Evse(
    val connectors: List<Connector>,
    val groupName: String,
    val id: Int
)