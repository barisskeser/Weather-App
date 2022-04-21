package com.baris.weatherapp.ui.weather_list


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.ViewModel
import com.baris.weatherapp.common.Resource
import com.baris.weatherapp.domain.use_case.GetWeatherUseCase
import kotlinx.coroutines.flow.onEach

@HiltViewModel
class WeatherListViewModel @Inject constructor(
    private val getWeatherUseCase: GetWeatherUseCase
): ViewModel() {

    private val _state = mutableStateOf(WeatherListState())

    fun getWeatherState(lat: Double, lon: Double, key: String, lang: String): State<WeatherListState> {
        getWeatherUseCase.invoke(lat, lon, key, lang).onEach { result ->
            when(result){
                is Resource.Loading -> {
                    _state.value = WeatherListState(isLoading = true)
                }

                is Resource.Success -> {
                    _state.value = WeatherListState(weather = result.data)
                }

                is Resource.Error -> {
                    _state.value = WeatherListState(error = result.message ?: "An unexpected error occured!")
                }
            }
        }

        return _state
    }

}