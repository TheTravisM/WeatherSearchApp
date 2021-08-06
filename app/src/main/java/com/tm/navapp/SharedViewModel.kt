package com.tm.navapp

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.tm.navapp.data.Weather
import com.tm.navapp.data.WeatherRepository

class SharedViewModel : ViewModel() {

    // Link to Date Reader/getter
    var weatherRepository: WeatherRepository = WeatherRepository()

    val currentWeatherRepository: MutableLiveData<Weather> = MutableLiveData()

    var cityText : String = ""

    val weather: LiveData<Weather> = liveData {
        val data= weatherRepository.getWeather(cityText)
        // If data exist let it emit
        data?.let {
            Log.i("Shared VM", it.toString())
            emit(it)
        }
    }

    // This function takes in Lambda function that contains suspend function
//    val weather: LiveData<Weather> = liveData {
//        val data= weatherRepository.getWeather()
//        // If data exist let it emit
//        data?.let {
//            Log.i("Shared VM", it.toString())
//            emit(it)
//        }
//    }
}



/* --

    init {
        val data = weatherRepository.getWeather(app, "weather_data.json")
        data?.forEach {
            Log.i("Travis Weather Data From Assets", "Current Weather: ${it.current}")
        }
    }
        /*  -- Get Text From Assets  */
    init {
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