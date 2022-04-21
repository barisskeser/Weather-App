package com.baris.weatherapp.domain.repository

import com.baris.weatherapp.data.remote.dto.WeatherDto
import com.baris.weatherapp.domain.model.Weather

interface WeatherRepository {

    suspend fun getWeather(
        lat: Double,
        lon: Double,
        key: String,
        lang: String
    ): Weather

}