package com.noxo.evapp.navigation

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateListOf

class NavigationManager {
    private val _backStack = mutableStateListOf<NavigationRoute>(NavigationRoute.Login)
    val backStack = derivedStateOf { _backStack.toList() }

    fun openStationList() {
        if (!backStack.value.contains(NavigationRoute.Station)) {
            _backStack.add(NavigationRoute.Station)
        }
    }

    fun goBack() {
        if (_backStack.size > 1) _backStack.removeLastOrNull()
    }
}