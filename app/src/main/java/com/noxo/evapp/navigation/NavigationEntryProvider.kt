package com.noxo.evapp.navigation

import androidx.navigation3.runtime.EntryProviderScope
import com.noxo.evapp.ui.LoginScreen
import com.noxo.evapp.ui.LoginViewModel
import com.noxo.evapp.ui.StationScreen
import com.noxo.evapp.ui.StationViewModel
import org.koin.androidx.compose.koinViewModel

fun EntryProviderScope<NavigationRoute>.appEntries()  {
    entry<NavigationRoute.Login> {
        val viewmodel : LoginViewModel = koinViewModel()
        LoginScreen(viewmodel)
    }
    entry<NavigationRoute.Station> {
        val viewmodel : StationViewModel = koinViewModel()
        StationScreen(viewmodel)
    }
}