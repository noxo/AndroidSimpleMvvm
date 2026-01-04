package com.noxo.evapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.noxo.evapp.navigation.NavigationManager
import com.noxo.evapp.navigation.appEntries
import com.noxo.evapp.theme.EvAppTheme
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    private val navigationManager: NavigationManager by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            EvAppTheme {
                Scaffold (
                    modifier = Modifier
                        .fillMaxSize()
                        .safeDrawingPadding()
                ) { contentPadding ->
                    Surface(modifier = Modifier.padding(contentPadding)) {
                        NavDisplay(
                            entryDecorators = listOf(
                                rememberSaveableStateHolderNavEntryDecorator(),
                                rememberViewModelStoreNavEntryDecorator()
                            ),
                            backStack = navigationManager.backStack.value,
                            entryProvider = entryProvider {
                                appEntries()
                            }
                        )
                    }
                }
            }
        }
    }

}
