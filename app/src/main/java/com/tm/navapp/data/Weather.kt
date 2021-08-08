package com.tm.navapp.data

import com.squareup.moshi.Json
import androidx.annotation.Keep

@Keep
data class Weather(
    @Json(name = "current")
    val current: Current,
    @Json(name = "location")
    val location: Location,
    @Json(name = "request")
    val request: Request
)
{
    @Keep
    data class Current(
        @Json(name = "cloudcover")
        val cloudcover: Int,
        @Json(name = "feelslike")
        val feelslike: Int,
        @Json(name = "humidity")
        val humidity: Int,
        @Json(name = "is_day")
        val isDay: String,
        @Json(name = "observation_time")
        val observationTime: String,
        @Json(name = "precip")
        val precip: Float,
        @Json(name = "pressure")
        val pressure: Int,
        @Json(name = "temperature")
        val temperature: Int,
        @Json(name = "uv_index")
        val uvIndex: Int,
        @Json(name = "visibility")
        val visibility: Int,
        @Json(name = "weather_code")
        val weatherCode: Int,
        @Json(name = "weather_descriptions")
        val weatherDescriptions: List<String>,
        @Json(name = "weather_icons")
        val weatherIcons: List<String>,
        @Json(name = "wind_degree")
        val windDegree: Int,
        @Json(name = "wind_dir")
        val windDir: String,
        @Json(name = "wind_speed")
        val windSpeed: Int
    )

    @Keep
    data class Location(
        @Json(name = "country")
        val country: String,
        @Json(name = "lat")
        val lat: String,
        @Json(name = "localtime")
        val localtime: String,
        @Json(name = "localtime_epoch")
        val localtimeEpoch: Int,
        @Json(name = "lon")
        val lon: String,
        @Json(name = "name")
        val name: String,
        @Json(name = "region")
        val region: String,
        @Json(name = "timezone_id")
        val timezoneId: String,
        @Json(name = "utc_offset")
        val utcOffset: String
    )

    @Keep
    data class Request(
        @Json(name = "language")
        val language: String,
        @Json(name = "query")
        val query: String,
        @Json(name = "type")
        val type: String,
        @Json(name = "unit")
        val unit: String
    )
}