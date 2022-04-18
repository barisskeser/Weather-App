package com.baris.weatherapp.data.local.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WeatherLoc(
    @PrimaryKey
    val name: String,
    val lat: Double,
    val lng: Double
)
