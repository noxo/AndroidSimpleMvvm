package com.noxo.evapp.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@Composable
fun Navigation() {

    val navController: NavHostController = rememberNavController()

    NavHost(navController = navController, startDestination = "Login") {
        composable("Login") {
            val loginViewModel = hiltViewModel<LoginViewModel>()
            LoginScreen(loginViewModel)
            LaunchedEffect(key1 = "acv") {
                loginViewModel.uiState.collect {
                    if (it.loggedIn) {
                        navController.navigate("Stations/acb")
                    }
                }
            }
        }
        composable("Stations/{authToken}") {
            val stationsViewModel = hiltViewModel<StationViewModel>()
            StationScreen(stationsViewModel, it.arguments!!.getString("authToken")!!)
        }
    }


}