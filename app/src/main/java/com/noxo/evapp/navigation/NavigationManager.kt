package com.noxo.evapp.navigation

import com.noxo.evapp.navigation.NavigationRoutes.Default
import kotlinx.coroutines.flow.MutableStateFlow

//https://medium.com/google-developer-experts/modular-navigation-with-jetpack-compose-fda9f6b2bef7

class NavigationManager {
    var commands = MutableStateFlow(Default)
    fun navigate(
        directions: NavigationCommand
    ) {
        commands.value = directions
    }

}