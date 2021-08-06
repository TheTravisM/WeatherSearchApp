package com.tm.navapp.ui.home


import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.tm.navapp.data.MoshiWeatherResponse
import com.tm.navapp.data.WeatherRepository


//class HomeViewModel : ViewModel() {

class HomeViewModel(app: Application) : AndroidViewModel(app) {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    // Link to Date Reader/getter
    var weatherRepository: WeatherRepository = WeatherRepository()

    // This function takes in Lambda function that contains suspend function
    val weather: LiveData<List<MoshiWeatherResponse>> = liveData {
        val data = weatherRepository.getWeather()
        emit(data)
        // Log.i("Travis Weather Data From Assets", "Current Weather: ${it.current}")
        Log.i("Travis Weather Data From Assets", data.toString())
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