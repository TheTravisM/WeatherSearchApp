package com.tm.navapp.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("current?access_key=3c0a7ca1a1cf96c2999e59f8d379be7d")
    suspend fun getWeather(@Query("query") city: String?): Response<Weather>

}