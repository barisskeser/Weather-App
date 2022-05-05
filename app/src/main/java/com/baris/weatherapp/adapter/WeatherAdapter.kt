package com.baris.weatherapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.baris.weatherapp.R
import com.baris.weatherapp.data.remote.dto.WeatherDetail
import com.baris.weatherapp.data.remote.dto.getIconResource
import com.baris.weatherapp.databinding.WeatherListItemBinding
import com.baris.weatherapp.domain.model.Weather
import java.sql.Timestamp
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.minutes

class WeatherAdapter(
    private val weatherList: ArrayList<Weather>
) : RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        //val view = inflater.inflate(R.layout.weather_list_item, parent, false)
        val binding = WeatherListItemBinding.inflate(inflater, parent, false)
        return WeatherViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val place = weatherList[position].place
        val dt = weatherList[position].current.dt
        val time =
            Timestamp(dt).time.hours.toString() + ":" + Timestamp(dt).time.minutes
        val iconResource = weatherList[position].current.weatherDetail.first().getIconResource()
        val description = weatherList[position].current.weatherDetail.first().description
        val rain = weatherList[position].daily.first().rain
        val temp = weatherList[position].current.temp

        holder.view.itemTitle.text = "$place • $time"
        holder.view.itemWeatherIcon.setImageResource(iconResource)
        holder.view.itemDesc.text = description
        holder.view.itemRainPerc.text = rain.toString()
        holder.view.itemTemp.text = temp.toString()
    }

    override fun getItemCount(): Int {
        return weatherList.size
    }

    class WeatherViewHolder(var view: WeatherListItemBinding) : RecyclerView.ViewHolder(view.root)

    @SuppressLint("NotifyDataSetChanged")
    fun update(newList: List<Weather>) {
        weatherList.clear()
        weatherList.addAll(newList)
        notifyDataSetChanged()
    }
}