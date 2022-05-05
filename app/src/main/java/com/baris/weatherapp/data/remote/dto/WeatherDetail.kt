package com.baris.weatherapp.data.remote.dto

import android.graphics.Bitmap
import com.baris.weatherapp.R

data class WeatherDetail(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)

fun WeatherDetail.getIconResource(name: String = this.icon): Int {
    when(name){
        "01d" -> return R.drawable.ic_01d
        "01n" -> return R.drawable.ic_01n
        "02d" -> return R.drawable.ic_02d
        "02n" -> return R.drawable.ic_02n
        "03d" -> return R.drawable.ic_03d
        "03n" -> return R.drawable.ic_03n
        "04d" -> return R.drawable.ic_04d
        "04n" -> return R.drawable.ic_04n
        "09d" -> return R.drawable.ic_09d
        "09n" -> return R.drawable.ic_09n
        "10d" -> return R.drawable.ic_10d
        "10n" -> return R.drawable.ic_10n
        "11d" -> return R.drawable.ic_11n
        "11n" -> return R.drawable.ic_11n
        "13d" -> return R.drawable.ic_13d
        "13n" -> return R.drawable.ic_13n
        "50d" -> return R.drawable.ic_50d
        "50n" -> return R.drawable.ic_50d
        else -> return 0
    }
}