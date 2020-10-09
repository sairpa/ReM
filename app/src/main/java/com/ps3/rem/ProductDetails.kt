package com.ps3.rem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class ProductDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)
    }
    fun buy(view: View)
    {
        Toast.makeText(applicationContext,"Feature in Works!!! ✌✔",Toast.LENGTH_SHORT).show()
    }
}