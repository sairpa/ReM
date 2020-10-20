package com.ps3.rem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_product_details.*

class ProductDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)
        val typep = intent.getStringExtra("Type")
        if(typep == "Solar"){
            tvpname.setText("Solar Plant")
        }
        if(typep == "Wind"){
            tvpname.setText("Wind Plant")
        }
        if(typep == "GeoT"){
            tvpname.setText("Geo Thermal Plant")
        }
    }
    fun buy(view: View)
    {
        Toast.makeText(applicationContext,"Feature in Works!!! ✌✔",Toast.LENGTH_SHORT).show()
    }
}