package com.uygulamalarim.weather_app.WeatherService.model


import com.google.gson.annotations.SerializedName

data class Clouds(
    @SerializedName("all")
    val all: Int
)