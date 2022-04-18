package com.baris.weatherapp.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.baris.weatherapp.data.local.room.dao.WeatherDao
import com.baris.weatherapp.data.local.room.entity.WeatherLoc

@Database(
    entities = [WeatherLoc::class],
    version = 1
)
abstract class WeatherDatabase: RoomDatabase() {

    abstract val weatherDao: WeatherDao

    /*companion object {
        @Volatile
        private var INSTANCE: WeatherDatabase? = null

        fun getInstance(context: Context): WeatherDatabase {
            synchronized(this){
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    WeatherDatabase::class.java,
                    "weather_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }*/

}