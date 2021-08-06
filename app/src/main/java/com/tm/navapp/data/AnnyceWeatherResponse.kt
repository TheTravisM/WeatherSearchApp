package com.tm.navapp.data


data class AnnyceWeatherResponse (
    val temperature: Int,
    val uvIndex: Int,
    val weatherDescriptions: List<String>,
    val weatherIcons: List<String>,
    val windDir: String,
    )