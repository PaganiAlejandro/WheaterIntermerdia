package com.aplicacion.wheater.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.aplicacion.wheater.data.entities.listWheaterByDay
import com.aplicacion.wheater.data.entities.listWheaterByHour
import com.aplicacion.wheater.ui.screen.currentCity.HeaderCurrentScreen
import com.aplicacion.wheater.ui.screen.currentCity.listRowWheaterDay
import com.aplicacion.wheater.ui.screen.currentCity.listRowWheaterHour

@Composable
fun CurrentCityScreen() {
    Column() {
        HeaderCurrentScreen()
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


