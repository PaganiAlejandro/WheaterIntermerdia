package com.aplicacion.wheater.data.entities

data class Sys(
    val country: String,
    val id: Int? = 0,
    val message: Double? = 0.0,
    val sunrise: Int,
    val sunset: Int,
    val type: Int? = 0
)