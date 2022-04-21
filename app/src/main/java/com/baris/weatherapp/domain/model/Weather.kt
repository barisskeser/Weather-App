package com.baris.weatherapp.domain.model

import com.baris.weatherapp.data.remote.dto.Current
import com.baris.weatherapp.data.remote.dto.Daily
import com.baris.weatherapp.data.remote.dto.Hourly

data class Weather(
    val current: Current,
    val daily: List<Daily>,
    val hourly: List<Hourly>
)