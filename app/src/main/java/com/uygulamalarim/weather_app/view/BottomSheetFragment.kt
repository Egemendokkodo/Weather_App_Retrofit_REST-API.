package com.uygulamalarim.weather_app.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.uygulamalarim.weather_app.R
import kotlinx.android.synthetic.main.fragment_bottom_sheet.*

class BottomSheetFragment : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addProvince.setOnClickListener{
            if (!provinceEditText.text.toString().isEmpty()){
                val i=Intent(context,MainActivity::class.java)
                i.putExtra("sehir",provinceEditText.text.toString())
                this.dismiss()
                MainActivity().finish()
                startActivity(i)


            }else{
                Toast.makeText(context, "Please enter a city name.", Toast.LENGTH_SHORT).show()
            }

            }
    }


}