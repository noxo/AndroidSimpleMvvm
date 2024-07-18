package com.noxo.evapp.navigation

import androidx.navigation.NamedNavArgument

object NavigationRoutes {
    val login  = object : NavigationCommand {
        override val arguments = emptyList<NamedNavArgument>()
        override val destination = "login"
    }

    val stations = object : NavigationCommand {
        override val arguments = emptyList<NamedNavArgument>()
        override val destination = "stations"
    }

}