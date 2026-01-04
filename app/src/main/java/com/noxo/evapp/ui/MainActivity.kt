package com.noxo.evapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.noxo.evapp.navigation.NavigationManager
import com.noxo.evapp.theme.EvAppTheme
import kotlinx.coroutines.flow.consumeAsFlow
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    private val navigationManager: NavigationManager by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            EvAppTheme {
                val navController = rememberNavController()
                LaunchedEffect(navigationManager.commands) {
                    navigationManager.commands.consumeAsFlow().collect {
                        navController.navigate(route = it.destination)
                    }
                }
                Scaffold (
                    modifier = Modifier
                        .fillMaxSize()
                        .safeDrawingPadding()
                ) { contentPadding ->
                    Surface(modifier = Modifier.padding(contentPadding)) {
                        Navigation(navController)
                    }
                }
            }
        }
    }
}
