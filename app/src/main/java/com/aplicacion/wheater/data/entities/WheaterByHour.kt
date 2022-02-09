package com.aplicacion.wheater.data.entities

data class WheaterByHour(
    val hour: String,
    val wheater: String,
    val probability: String,
    val temperature: String
)

val listWheaterByHour = listOf(
    WheaterByHour("Now", "SUNNY", "0%", "25°"),
    WheaterByHour("10am", "CLOUDS", "30%", "19°"),
    WheaterByHour("11am", "CLOUDS", "50%", "19°"),
    WheaterByHour("12am", "STORM", "90%", "14°"),
    WheaterByHour("13am", "RAIN", "100%", "19°"),
    WheaterByHour("14am", "RAIN", "80%", "19°"),
    WheaterByHour("15am", "CLOUDS", "0%", "24°")
)

enum class WHEATER {
    SUNNY, CLOUDS, RAIN, STORM
}