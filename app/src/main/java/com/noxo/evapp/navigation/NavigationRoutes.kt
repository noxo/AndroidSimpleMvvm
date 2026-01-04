package com.noxo.evapp.navigation

import androidx.navigation3.runtime.NavKey

sealed class NavigationRoute : NavKey {
    object Login : NavigationRoute()
    object Station : NavigationRoute()
}