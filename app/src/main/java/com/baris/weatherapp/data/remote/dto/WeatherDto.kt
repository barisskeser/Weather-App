package com.baris.weatherapp.data.remote.dto

import com.baris.weatherapp.domain.model.Weather

data class WeatherDto(
    val current: Current,
    val daily: List<Daily>,
    val hourly: List<Hourly>,
    val lat: Double,
    val lon: Double,
    val timezone: String,
    val timezone_offset: Int
)

fun WeatherDto.toWeather(): Weather {
    return Weather(
        current = this.current,
        daily = this.daily,
        hourly = this.hourly
    )
}