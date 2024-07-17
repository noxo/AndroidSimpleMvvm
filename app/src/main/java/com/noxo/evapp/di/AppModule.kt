package com.noxo.evapp.di

import android.content.Context
import com.noxo.evapp.navigation.NavigationManager
import com.noxo.evapp.repository.AuthRepository
import com.noxo.evapp.repository.EVStationRepository
import com.noxo.evapp.repository.FakeEVStationRepository
import com.noxo.evapp.repository.FakeUserRepository
import com.noxo.evapp.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideUserRepository(@ApplicationContext context: Context): UserRepository {
        return FakeUserRepository(context)
    }

    @Provides
    @Singleton
    fun provideEvStationRepository(@ApplicationContext context: Context): EVStationRepository {
        return FakeEVStationRepository(context)
    }

    @Provides
    @Singleton
    fun provideAuthRepository(@ApplicationContext context: Context): AuthRepository {
        return AuthRepository(context)
    }

    @Provides
    @Singleton
    fun provideNavigationManager(): NavigationManager {
        return NavigationManager()
    }
}