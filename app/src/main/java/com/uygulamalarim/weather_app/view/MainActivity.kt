package com.uygulamalarim.weather_app.view



import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.uygulamalarim.weather_app.R
import com.uygulamalarim.weather_app.WeatherService.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_bottom_sheet.*

// api için konu anlatımı:
// https://javascript.plainenglish.io/display-7-day-weather-forecast-with-openweather-api-aac8ba21c9e3




class MainActivity : AppCompatActivity() {


    private lateinit var viewModel: MainViewModel
    private lateinit var GET:SharedPreferences
    private lateinit var SET:SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val bottomSheetFragment=BottomSheetFragment()
        addbtn.setOnClickListener{
            bottomSheetFragment.show(supportFragmentManager,"Bottom Sheet Dialog")
        }

        GET=getSharedPreferences(packageName, MODE_PRIVATE)
        SET=GET.edit()
        viewModel= ViewModelProvider(this).get(MainViewModel::class.java)
        var cName=GET.getString("cityName","hatay")
        val sehir=intent.getStringExtra("sehir")


        if (sehir!=null){
            viewModel.refreshData(sehir)
        }else{
            viewModel.refreshData(cName!!)
        }




        getLiveData()




    }



    private fun getLiveData() {
        viewModel.weather_data.observe(this) { data ->
            data?.let {
                tv_degree.text = data.main.temp.toString()
                tv_city_code.text = data.sys.country.toString()
                tv_city_name.text = data.name.toString()
                tv_humidity.text = data.main.humidity.toString()
                tv_wind_speed.text = data.wind.speed.toString()
                tv_lat.text = data.coord.lat.toString()
                tv_lon.text = data.coord.lon.toString()

                Glide.with(this)
                    .load("http://openweathermap.org/img/wn/" + data.weather.get(0).icon + "10d@2x.png")
                    .into(img_weather_pictures)

            }

        }




    }

    override fun onPause() {
        super.onPause()
        this.finish()
    }
}