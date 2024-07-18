package com.noxo.evapp.navigation

import kotlinx.coroutines.channels.Channel
//https://medium.com/google-developer-experts/modular-navigation-with-jetpack-compose-fda9f6b2bef7
class NavigationManager {
    var commands = Channel<NavigationCommand>(Channel.CONFLATED)
    suspend fun navigate(
        directions: NavigationCommand
    ) {
        commands.send(directions)
    }

}