package com.aplicacion.wheater.data.entities

data class WheaterByDay(
    val day: String,
    val wheater: String,
    val probability: String,
    val temperature: String
)

val listWheaterByDay = listOf(
    WheaterByDay("Now", "SUNNY", "0%", "25°"),
    WheaterByDay("Tomorrow", "CLOUDS", "30%", "19°"),
    WheaterByDay("Moday", "CLOUDS", "50%", "19°"),
    WheaterByDay("Tuesday", "STORM", "90%", "14°"),
    WheaterByDay("Wednesday", "RAIN", "100%", "19°"),
    WheaterByDay("Thursday", "RAIN", "80%", "19°"),
    WheaterByDay("Friday", "CLOUDS", "0%", "24°")
)