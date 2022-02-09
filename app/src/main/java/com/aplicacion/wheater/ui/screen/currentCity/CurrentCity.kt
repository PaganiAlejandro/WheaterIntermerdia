package com.aplicacion.wheater.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aplicacion.wheater.data.entities.listWheaterByDay
import com.aplicacion.wheater.data.entities.listWheaterByHour
import com.aplicacion.wheater.ui.screen.currentCity.HeaderCurrentScreen
import com.aplicacion.wheater.ui.screen.currentCity.listRowWheaterDay
import com.aplicacion.wheater.ui.screen.currentCity.listRowWheaterHour
import com.aplicacion.wheater.viewModel.CurrentCityViewModel
import org.koin.androidx.viewmodel.compat.SharedViewModelCompat.sharedViewModel
import org.koin.androidx.viewmodel.compat.ViewModelCompat.getViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

@Composable
fun CurrentCityScreen() {

     val viewModelWheaterByCityName = getViewModel<CurrentCityViewModel>()

     viewModelWheaterByCityName.getWheaterByCityName("Tandil")
     val wheater = viewModelWheaterByCityName.wheaterCityName.observeAsState()

    Column() {
       // HeaderCurrentScreen(wheater = wheater)
        WheaterByHour()
        WheaterByDay()
    }
}

@Composable
fun WheaterByHour() {
    // TODO obtener los datos del viewmodel
    listRowWheaterHour(listWheaterByHour)
}

@Composable
fun WheaterByDay() {
    // TODO obtener los datos del viewmodel
    listRowWheaterDay(listWheaterByDay)
}


