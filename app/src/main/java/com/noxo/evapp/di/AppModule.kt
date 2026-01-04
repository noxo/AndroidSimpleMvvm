package com.noxo.evapp.di

import com.noxo.evapp.navigation.NavigationManager
import com.noxo.evapp.repository.AuthRepository
import com.noxo.evapp.repository.AuthRepositoryImpl
import com.noxo.evapp.repository.EVStationRepository
import com.noxo.evapp.repository.EVStationRepositoryImpl
import com.noxo.evapp.repository.UserRepository
import com.noxo.evapp.repository.UserRepositoryImpl
import com.noxo.evapp.service.AuthService
import com.noxo.evapp.service.DataStoreAuthService
import com.noxo.evapp.service.EVStationService
import com.noxo.evapp.service.FakeEVStationService
import com.noxo.evapp.service.FakeUserService
import com.noxo.evapp.service.UserService
import com.noxo.evapp.ui.LoginViewModel
import com.noxo.evapp.ui.StationViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // ---------- View models ----------
    viewModel { LoginViewModel(get(), get(), get()) }
    viewModel { StationViewModel(get(), get()) }

    // ---------- Services ----------
    single<AuthService> { DataStoreAuthService(androidContext()) }
    single<UserService> { FakeUserService(androidContext()) }
    single<EVStationService> { FakeEVStationService(androidContext()) }

    // ---------- Repositories ----------
    single<AuthRepository> { AuthRepositoryImpl(get()) }
    single<UserRepository> { UserRepositoryImpl(get()) }
    single<EVStationRepository> { EVStationRepositoryImpl(get()) }

    // ---------- Navigation ----------
    single { NavigationManager() }

}