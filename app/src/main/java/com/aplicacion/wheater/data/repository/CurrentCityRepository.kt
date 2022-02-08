package com.aplicacion.wheater.data.repository

import com.aplicacion.wheater.data.entities.AppResult
import com.aplicacion.wheater.data.entities.WheatherToday
import com.aplicacion.wheater.data.network.CurrentCityNetworkResource
import com.aplicacion.wheater.util.loading
import kotlinx.coroutines.flow.Flow

class CurrentCityRepository(
    private val currentCityNetworkResource: CurrentCityNetworkResource
) {

    fun getCituByName(cityName: String) : Flow<AppResult<WheatherToday>> =
        currentCityNetworkResource.getWheatherByCityName(cityName).loading()

}