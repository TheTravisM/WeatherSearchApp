package com.tm.navapp.data

import retrofit2.Response
import retrofit2.http.GET

interface WeatherApi {

    @GET("")
    suspend fun getWeather(): Response<List<Weather>>

}