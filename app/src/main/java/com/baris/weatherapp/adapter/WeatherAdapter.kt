package com.baris.weatherapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.baris.weatherapp.R
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
        val icon = weatherList[position].current.weatherDetail.first().icon
        val description = weatherList[position].current.weatherDetail.first().description
        val rain = weatherList[position].daily.first().rain
        val temp = weatherList[position].current.temp

        holder.view.itemTitle.text = "$place • $time"
        holder.view.itemWeatherIcon.setImageResource(getImageFromDrawable(icon))
        holder.view.itemDesc.text = description
        holder.view.itemRainPerc.text = rain.toString()
        holder.view.itemTemp.text = temp.toString()
    }

    override fun getItemCount(): Int {
        return weatherList.size
    }

    class WeatherViewHolder(var view: WeatherListItemBinding) : RecyclerView.ViewHolder(view.root) {

    }

    private fun getImageFromDrawable(name: String): Int {
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

    @SuppressLint("NotifyDataSetChanged")
    fun update(newList: List<Weather>) {
        weatherList.clear()
        weatherList.addAll(newList)
        notifyDataSetChanged()
    }
}