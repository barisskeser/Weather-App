package com.baris.weatherapp.data.remote.dto

data class Current(
    val clouds: Int,
    val dew_point: Double,
    val dt: Int,
    val feels_like: Double,
    val humidity: Int,
    val pressure: Int,
    val sunrise: Int,
    val sunset: Int,
    val temp: Double,
    val uvi: Int,
    val visibility: Int,
    val weatherDetail: List<WeatherDetail>,
    val wind_deg: Int,
    val wind_speed: Int
)