package com.tm.navapp

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.tm.navapp.data.Weather
import com.tm.navapp.data.WeatherRepository

class SharedViewModel(app: Application) : AndroidViewModel(app) {

    // Link to Date Reader/getter
    var weatherRepository: WeatherRepository = WeatherRepository()

    // This function takes in Lambda function that contains suspend function
    val weather: LiveData<List<Weather>> = liveData {
        val data = weatherRepository.getWeather()
        Log.i("SharedVM Line 31", data.toString())
        emit(data)
        // Log.i("Travis Weather Data From Assets", "Current Weather: ${it.current}")
        Log.i("SharedVM Line 31", data.toString())
    }
}



/* --

    init {
        val data = weatherRepository.getWeather(app, "weather_data.json")
        data?.forEach {
            Log.i("Travis Weather Data From Assets", "Current Weather: ${it.current}")
        }

        /*  -- Get Text From Assets  */
        val data = weatherRepository.getTextFromAsset(app, "weather_data.json")
        Log.i("Travis Weather Data From Assets",data)


        Log.i("Travis Weather Data From Assets", data.toString())
    }

    /* Pull Data From Raw File */
    init {
        val data = weatherRepository.getTextFromResource(app, R.raw.weather_data)
        Log.i("Travis Weather Data From Raw File",data)
    }



 */