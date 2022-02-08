package com.aplicacion.wheater.data.network

import com.aplicacion.wheater.BuildConfig
import com.aplicacion.wheater.data.entities.AppResult
import com.aplicacion.wheater.data.entities.WheatherToday
import com.aplicacion.wheater.data.services.WheaterService
import com.aplicacion.wheater.util.CoroutinesDispatcherProvider
import com.aplicacion.wheater.util.parse
import com.aplicacion.wheater.util.toNetworkError
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map


interface CurrentCityNetworkResource {

    fun getWheaterByLocation(lat:String, long: String): Flow<AppResult<WheatherToday>>

    fun getWheatherByCityName(name: String): Flow<AppResult<WheatherToday>>
}

class CurrentCityNetworkResourceImpl(
    private val wheaterService: WheaterService,
    private val coroutinesDispatcherProvider: CoroutinesDispatcherProvider
): CurrentCityNetworkResource {

    override fun getWheaterByLocation(lat: String, long: String): Flow<AppResult<WheatherToday>> = flow {
        emit(wheaterService.getWheaterCurrentByLocation(
            latitude = lat,
            longitude = long,
            BuildConfig.API_KEY)
        )
    }.catch { error -> emit(error.toNetworkError()) }
        .map { res -> res.parse { it } }
        .flowOn(coroutinesDispatcherProvider.io)

    override fun getWheatherByCityName(name: String): Flow<AppResult<WheatherToday>> = flow {
        emit(wheaterService.getWheaterCurrentByCityName(
            cityName = name,
            BuildConfig.API_KEY)
        )
    }.catch { error -> emit(error.toNetworkError()) }
        .map { res -> res.parse { it } }
        .flowOn(coroutinesDispatcherProvider.io)
}