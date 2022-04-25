package com.baris.weatherapp.domain.use_case

import com.baris.weatherapp.common.Resource
import com.baris.weatherapp.data.remote.dto.WeatherDto
import com.baris.weatherapp.domain.model.Weather
import com.baris.weatherapp.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(
    private val repository: WeatherRepository
) {

    operator fun invoke(lat: Double, lon: Double, key: String, lang: String): Flow<Resource<Weather>> = flow {
        // TODO("BURAYA GELMIYOR")
        println("invoke")
        try {
            emit(Resource.Loading<Weather>())
            println("loding emitted")
            val weather = repository.getWeather(lat, lon, key, lang)
            println("data got")
            emit(Resource.Success<Weather>(weather))
        } catch (e: HttpException){
            emit(Resource.Error<Weather>(message = e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException){
            emit(Resource.Error<Weather>(message = "Couldn't reach server. Check your internet connection"))
        }
    }

}