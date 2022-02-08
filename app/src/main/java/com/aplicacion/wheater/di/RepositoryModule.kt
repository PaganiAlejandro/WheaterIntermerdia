package com.aplicacion.wheater.di

import com.aplicacion.wheater.data.repository.CurrentCityRepository
import org.koin.dsl.module

val repositoryModule = module {

    single { CurrentCityRepository(get())}
}