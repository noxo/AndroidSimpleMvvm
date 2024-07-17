package com.noxo.evapp.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.noxo.evapp.navigation.NavigationRoutes

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationRoutes.login.destination) {
        composable(NavigationRoutes.login.destination) {
            val loginViewModel = hiltViewModel<LoginViewModel>()
            LoginScreen(loginViewModel)
        }
        composable(NavigationRoutes.stations.destination) {
            val stationsViewModel = hiltViewModel<StationViewModel>()
            StationScreen(stationsViewModel)
        }
    }
}