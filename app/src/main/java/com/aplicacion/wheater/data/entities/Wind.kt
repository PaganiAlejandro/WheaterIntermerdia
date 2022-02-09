package com.aplicacion.wheater.data.entities

data class Wind(
    val deg: Int,
    val speed: Double,
    val gust: Double? = 0.0
)