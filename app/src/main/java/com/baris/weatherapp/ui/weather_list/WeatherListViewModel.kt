package com.baris.weatherapp.ui.weather_list


import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.ViewModel
import com.baris.weatherapp.common.Resource
import com.baris.weatherapp.domain.model.Weather
import com.baris.weatherapp.domain.use_case.GetWeatherUseCase
import kotlinx.coroutines.flow.onEach

@HiltViewModel
class WeatherListViewModel @Inject constructor(
    private val getWeatherUseCase: GetWeatherUseCase
): ViewModel() {

    private val _state = mutableStateOf(WeatherListState())

    private val _weather = MutableLiveData<Weather>()
    val weatherLiveData: LiveData<Weather> = _weather

    fun getWeatherState(lat: Double, lon: Double, key: String, lang: String) {
        println("bakılıyor")
        getWeatherUseCase.invoke(lat, lon, key, lang).onEach { result ->
            when(result){
                is Resource.Loading -> {
                    println("loading")
                    _state.value = WeatherListState(isLoading = true)
                }

                is Resource.Success -> {
                    println("geldi ${result.data}")
                    _weather.value = result.data!!
                }

                is Resource.Error -> {
                    println("error ${result.message}")
                    _state.value = WeatherListState(error = result.message ?: "An unexpected error occured!")
                }
            }
        }
    }

}