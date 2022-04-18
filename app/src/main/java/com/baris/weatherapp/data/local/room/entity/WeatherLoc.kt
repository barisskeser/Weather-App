package com.baris.weatherapp.data.local.room.entity

import androidx.room.PrimaryKey

data class WeatherLoc(
    @PrimaryKey
    val name: String,
    val lat: Double,
    val lng: Double
)
