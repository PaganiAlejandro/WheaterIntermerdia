package com.aplicacion.wheater.data.services

import com.aplicacion.wheater.data.entities.WheatherToday
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WheaterService {

    @GET("weather")
    suspend fun getWheaterCurrentByLocation(
        @Query("lat") latitude: String,
        @Query("long") longitude: String,
        @Query("appid") appKey: String
    ): Response<WheatherToday>

    @GET("weather")
    suspend fun getWheaterCurrentByCityName(
        @Query("q") cityName: String,
        @Query("appid") appKey: String
    ): Response<WheatherToday>
}