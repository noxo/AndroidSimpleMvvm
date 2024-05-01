package com.noxo.evapp.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
@Composable
fun Navigation() {

    val loginViewModel = hiltViewModel<LoginViewModel>()
    val stationsViewModel = hiltViewModel<StationViewModel>()
    val navController: NavHostController = rememberNavController()

    NavHost(navController = navController, startDestination = "Login") {
        composable("Login") {
            LoginScreen(loginViewModel)
        }
        composable("Stations/{authToken}") {
            StationScreen(stationsViewModel, it.arguments!!.getString("authToken")!!)
        }
    }

    val lifecycleOwner = LocalLifecycleOwner.current
    loginViewModel.currentCredentials.observe(lifecycleOwner) { loginResult ->
        if (loginResult.isSuccess) {
            navController.navigate("Stations/${loginResult}")
        }
    }
}