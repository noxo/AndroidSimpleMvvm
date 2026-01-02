package com.noxo.evapp.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.noxo.evapp.navigation.NavigationRoutes
import org.koin.androidx.compose.koinViewModel

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationRoutes.login.destination) {
        composable(NavigationRoutes.login.destination) {
            val loginViewModel: LoginViewModel = koinViewModel()
            LoginScreen(loginViewModel)
        }
        composable(NavigationRoutes.stations.destination) {
            val stationsViewModel : StationViewModel = koinViewModel()
            StationScreen(stationsViewModel)
        }
    }
}