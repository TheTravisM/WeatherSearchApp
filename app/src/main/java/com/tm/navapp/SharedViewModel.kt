package com.tm.navapp

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tm.navapp.data.Weather
import com.tm.navapp.data.WeatherRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SharedViewModel : ViewModel() {

    // Link to Date Reader/getter
    var weatherRepository: WeatherRepository = WeatherRepository()

    //val currentWeatherRepository: MutableLiveData<Weather> = MutableLiveData()

    //val weather: MutableLiveData<Weather> = MutableLiveData()
    val weather: MutableLiveData<Weather> by lazy { MutableLiveData<Weather>() }

    suspend fun updateWeather(city:String) {
        val data= weatherRepository.getWeather(city)
        CoroutineScope(Dispatchers.Main).launch {
            Log.i("SharedModel", "setValue")
            weather.setValue(data)
        }
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