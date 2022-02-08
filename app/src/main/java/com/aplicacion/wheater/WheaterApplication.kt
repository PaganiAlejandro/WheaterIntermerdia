package com.aplicacion.wheater

import android.app.Application
import com.aplicacion.wheater.di.networkModule
import com.aplicacion.wheater.di.repositoryModule
import com.aplicacion.wheater.di.viewModelModul
import org.koin.core.context.startKoin

class WheaterApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                viewModelModul,
                networkModule,
                repositoryModule
            )
        }
    }
}