package com.tm.navapp

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tm.navapp.data.AnnyceWeatherRepository

class SharedViewModel(app: Application) : AndroidViewModel(app) {

    private val _quantity: MutableLiveData<Int> = MutableLiveData(0)
    val quantity: LiveData<Int> = _quantity

    var annyceWeatherRepository: AnnyceWeatherRepository = AnnyceWeatherRepository()

    init {
        val data = annyceWeatherRepository.getTextFromResource(app, R.raw.weather_data)
        Log.i("Travis_Weather",data)
    }

    fun increaseQuantity() {
        _quantity.value = _quantity.value!! + 1
    }

    fun decreaseQuantity() {
        if (_quantity.value!! > 0) {
            _quantity.value = _quantity.value!! - 1
        }

    }
}