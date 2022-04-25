package com.baris.weatherapp.ui.weather_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.State
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.baris.weatherapp.R
import com.baris.weatherapp.adapter.WeatherAdapter
import com.baris.weatherapp.databinding.WeatherListItemBinding
import com.baris.weatherapp.domain.model.Weather
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherListFragment : Fragment() {


    private var _binding: WeatherListItemBinding? = null

    private val viewModel: WeatherListViewModel by viewModels()

    private val weatherAdapter = WeatherAdapter(arrayListOf())

    private lateinit var weatherState: State<WeatherListState>

    private lateinit var weatherRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weather_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        observeLiveData()
        
        weatherRecyclerView = view.findViewById(R.id.weatherRecyclerView)
        weatherRecyclerView.layoutManager = LinearLayoutManager(context)
        weatherRecyclerView.adapter = weatherAdapter

        viewModel.getWeatherState(
            lat = 41.09,
            lon = 29.0,
            key = getString(R.string.weather_api_key),
            lang = "tr"
        )

    }

    private fun observeLiveData() {
        viewModel.weatherLiveData.observe(viewLifecycleOwner) {
            println(it)
            weatherAdapter.update(listOf(it))
        }
    }
}