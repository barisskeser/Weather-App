package com.baris.weatherapp.ui.weather_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.State
import androidx.fragment.app.viewModels
import com.baris.weatherapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherListFragment : Fragment() {

    private val viewModel: WeatherListViewModel by viewModels()

    private lateinit var weatherState: State<WeatherListState>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        weatherState = viewModel.getWeatherState(
            lat = 41.09,
            lon = 29.0,
            key = getString(R.string.weather_api_key),
            lang = "tr"
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weather_list, container, false)
    }

}