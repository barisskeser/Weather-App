package com.baris.weatherapp.data.repository

import com.baris.weatherapp.data.remote.WeatherApi
import com.baris.weatherapp.data.remote.dto.toWeather
import com.baris.weatherapp.domain.model.Weather
import com.baris.weatherapp.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {

    override suspend fun getWeather(
        lat: Double,
        lon: Double,
        key: String,
        lang: String
    ): Weather {
        return api.getWeather(lat, lon, key, lang).toWeather()
    }

}