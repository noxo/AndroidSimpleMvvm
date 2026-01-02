package com.noxo.evapp

import android.app.Application
import com.noxo.evapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class EvApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@EvApp)
            modules(appModule)
        }
    }
}