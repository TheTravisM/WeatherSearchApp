package com.tm.navapp.data

import android.content.Context
import android.util.Log
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

const val BASE_ENDPOINT_URL = "http://api.weatherstack.com/"
//const val Access_key = "2093b02f759229c1da497533ba4e672a"
//const val Access_key = "3c0a7ca1a1cf96c2999e59f8d379be7d"

class WeatherRepository {

    // Adding Retrofit Variable to pull in the API
    private val retrofit: Retrofit by lazy {

        // Create Moshi Class to added as an Argument to the create Method
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

        Retrofit.Builder()
            .baseUrl(BASE_ENDPOINT_URL)
            // Providing Moshi to the converter Factory
            // Moshi added as an Argument to the create Method
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    // Adding Private API Variable
    // Create it lazy by using lazy lambda
    // This is to have only one instance of the weather API available
    private val weatherApi: WeatherApi by lazy {
        retrofit.create(WeatherApi::class.java)
    }

    suspend fun getWeather(city:String): Weather? {
        val response = weatherApi.getWeather(city)
        if (response.isSuccessful) {
           return response.body()
        }
        return null
    }

}
    /* --
        // Get Data from Assets
        fun getTextFromAsset(context: Context, fileName: String): String {
            return context.resources.assets.open(fileName)
                // buffer reader handles file reading more efficiently
                .bufferedReader()
                .use { it.readText() }
        }

        // -- Get Data From Raw Files
        fun getTextFromResource(context: Context, resourceId: Int): String {
            // Allows us to get access to Raw Json file in Resources
            return context.resources.openRawResource(resourceId)
                // buffer reader handles file reading more efficiently
                .bufferedReader()
                .use{ it.readText() }
        }

    fun getCurrentWeather() {
        val response = weatherApi.getCurrentWeather()
        return if (response.isSuccessful)
            response.body() ?: emptyList()
        Log.i("Repository Line 48", response.toString())
        else
        emptyList()
    }
        fun getWeather(context: Context, fileName: String): List<Weather>? {
            // Allows us to get access to Assets Folder Raw Json file
            val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
            val listType = Types.newParameterizedType(
            List::class.java, Weather::class.java
            )
            val adapter: JsonAdapter<List<Weather>> = moshi.adapter(listType)
            return adapter.fromJson(getTextFromAsset(context, fileName))
        }

     --  */
