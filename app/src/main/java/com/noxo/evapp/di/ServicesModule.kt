package com.noxo.evapp.di

import android.content.Context
import com.noxo.evapp.service.MockEvService
import com.noxo.evapp.service.EvService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ServicesModule {
    @Provides
    fun provideEvService(@ApplicationContext context: Context): EvService {
        return MockEvService(context)
    }
}