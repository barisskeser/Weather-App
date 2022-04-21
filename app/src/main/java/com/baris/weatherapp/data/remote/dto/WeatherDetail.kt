package com.baris.weatherapp.data.remote.dto

data class WeatherDetail(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)