package com.noxo.evapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.noxo.evapp.theme.EvAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EvAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
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
                    loginViewModel.currentCredentials.observe(this) { loginResult ->
                        if (loginResult.isSuccess) {
                            navController.navigate("Stations/${loginResult}")
                        }
                    }
                }
            }
        }
    }
}
