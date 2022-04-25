package com.baris.weatherapp.di

import android.content.Context
import androidx.room.Room
import com.baris.weatherapp.R
import com.baris.weatherapp.common.Constants
import com.baris.weatherapp.data.local.room.WeatherDatabase
import com.baris.weatherapp.data.local.room.dao.WeatherDao
import com.baris.weatherapp.data.remote.WeatherApi
import com.baris.weatherapp.data.repository.WeatherRepositoryImpl
import com.baris.weatherapp.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainModule {

    @Provides
    @Singleton
    fun provideWeatherDao(@ApplicationContext context: Context): WeatherDao {
        return Room.databaseBuilder(
            context,
            WeatherDatabase::class.java,
            "weather_db"
        ).build().weatherDao
    }

    @Provides
    @Singleton
    fun provideWeatherApi(): WeatherApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL_WEATHER)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApi::class.java)
    }

    @Provides
    @Singleton
    fun provideWeatherRepository(api: WeatherApi): WeatherRepository {
        return WeatherRepositoryImpl(api)
    }
}