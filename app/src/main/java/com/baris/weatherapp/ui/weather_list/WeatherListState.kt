package com.baris.weatherapp.ui.weather_list

import com.baris.weatherapp.domain.model.Weather

data class WeatherListState(
    val weather: Weather? = null,
    val isLoading: Boolean = false,
    val error: String = ""
)