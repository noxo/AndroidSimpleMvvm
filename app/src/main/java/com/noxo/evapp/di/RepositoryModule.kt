package com.noxo.evapp.di

import android.content.Context
import com.noxo.evapp.repository.EVStationRepository
import com.noxo.evapp.repository.FakeEVStationRepository
import com.noxo.evapp.repository.FakeUserRepository
import com.noxo.evapp.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideUserRepository(@ApplicationContext context: Context): UserRepository {
        return FakeUserRepository(context)
    }

    @Provides
    fun provideEvStationRepository(@ApplicationContext context: Context): EVStationRepository {
        return FakeEVStationRepository(context)
    }
}