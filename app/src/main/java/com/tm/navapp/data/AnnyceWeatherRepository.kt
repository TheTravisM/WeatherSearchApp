package com.tm.navapp.data

import android.content.Context
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

const val BASE_ENDPOINT_URL = "http://api.weatherstack.com/current?access_key=2093b02f759229c1da497533ba4e672a&query=cincinnati"

class AnnyceWeatherRepository {


    // Adding Retrofit to pull in the API
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

    // Get Data From Raw Files
    fun getTextFromResource(context: Context, resourceId: Int): String {
        // Allows us to get access to Raw Json file in Resources
        return context.resources.openRawResource(resourceId)
            // buffer reader handles file reading more efficiently
            .bufferedReader()
            .use{ it.readText() }
    }

    // Get Data from Assets
    fun getTextFromAsset(context: Context, fileName: String): String {
        return context.resources.assets.open(fileName)
            // buffer reader handles file reading more efficiently
            .bufferedReader()
            .use { it.readText() }
    }

    fun getWeather(context: Context, fileName: String): List<MoshiWeatherResponse>? {
        // Allows us to get access to Assets Folder Raw Json file
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val listType = Types.newParameterizedType(
            List::class.java, MoshiWeatherResponse::class.java
        )
        val adapter: JsonAdapter<List<MoshiWeatherResponse>> = moshi.adapter(listType)
        return adapter.fromJson(getTextFromAsset(context, fileName))
    }

}