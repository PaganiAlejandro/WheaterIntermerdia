package com.aplicacion.wheater.di

import com.aplicacion.wheater.viewModel.CurrentCityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModul = module {

    viewModel {
        CurrentCityViewModel()
    }
}