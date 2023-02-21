package com.uygulamalarim.weather_app.Adapter

import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.uygulamalarim.weather_app.R
import com.uygulamalarim.weather_app.WeatherService.viewmodel.MainViewModel
import com.uygulamalarim.weather_app.view.MainActivity
import org.w3c.dom.Text


class RecyclerAdapter(private val list: ArrayList<MainViewModel>) :
    RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>(){


    private lateinit var viewModel: MainViewModel

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tv_city_code:TextView=itemView.findViewById(R.id.tv_city_code)
        val tv_city_name:TextView=itemView.findViewById(R.id.tv_city_name)
        val img_weather_pictures:ImageView=itemView.findViewById(R.id.img_weather_pictures)
        val tv_humidity:TextView=itemView.findViewById(R.id.tv_humidity)
        val tv_wind_speed:TextView=itemView.findViewById(R.id.tv_wind_speed)
        val tv_lat:TextView=itemView.findViewById(R.id.tv_lat)
        val tv_lon:TextView=itemView.findViewById(R.id.tv_lon)




    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.recyclerlayout, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = list[position]





    }



    override fun getItemCount(): Int {
        return list.size
    }
}