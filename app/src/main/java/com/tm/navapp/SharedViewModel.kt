package com.tm.navapp

import androidx.lifecycle.*
import com.tm.navapp.model.Weather
import com.tm.navapp.model.WeatherRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SharedViewModel : ViewModel() {

    // Link to Date Reader/getter
    private var weatherRepository: WeatherRepository = WeatherRepository()

    //val weather: MutableLiveData<Weather> = MutableLiveData()
    val weather: MutableLiveData<Weather> by lazy { MutableLiveData<Weather>() }

    // Shared Weather Function
    suspend fun updateWeather(city:String) {
        val data= weatherRepository.getWeather(city)
        CoroutineScope(Dispatchers.Main).launch {
            weather.setValue(data)
        }
    }

}