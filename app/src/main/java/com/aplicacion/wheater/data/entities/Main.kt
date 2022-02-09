package com.aplicacion.wheater.data.entities

data class Main(
    val feels_like: Double,
    val humidity: Int,
    val pressure: Int,
    val temp: Double,
    val temp_max: Double,
    val temp_min: Double,
    val sea_level: Int? = 0,
    val grnd_level: Int? = 0
)