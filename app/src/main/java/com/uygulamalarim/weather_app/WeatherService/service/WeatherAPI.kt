package com.uygulamalarim.weather_app.WeatherService.service

import com.uygulamalarim.weather_app.WeatherService.model.WeatherModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

// http://api.openweathermap.org/data/2.5/weather?q=bing%C3%B6l&APPID=04a42b96398abc8e4183798ed22f9485
interface WeatherAPI {

    @GET("data/2.5/weather?&units=metric&APPID=04a42b96398abc8e4183798ed22f9485")
    fun getData(
        @Query("q") cityName:String
    ):Single<WeatherModel>



}