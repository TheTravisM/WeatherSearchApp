package com.tm.navapp.ui.home


import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text


//    val etCity = findViewById<EditText>(R.id.etCity)
//    val etCountry = findViewById<EditText>(R.id.etCountry)
//    val etCityString = etCity.text.toString().trim()
//    val country = etCountry.text.toString().trim()
//    val tvResult = findViewById<TextView>(R.id.tvResult)
//    val queue = Volley.newRequestQueue(this)

}

