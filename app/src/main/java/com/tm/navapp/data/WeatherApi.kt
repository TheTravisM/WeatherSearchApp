package com.tm.navapp.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("current?access_key=2093b02f759229c1da497533ba4e672a")
    suspend fun getWeather(@Query("query") city: String?): Response<Weather>

}