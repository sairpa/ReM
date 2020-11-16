package com.ps3.rem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_product_details.*

class ProductDetails : AppCompatActivity() {
    lateinit var typep:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)
        typep = intent.getStringExtra("Type").toString()
        if(typep == "Solar"){
            tvpname.setText("Solar Plant")
        }
        if(typep == "Wind"){
            tvpname.setText("Wind Plant")
            tvchg0.setText("-> Blade Radius")
            tvchg1.setText("-> Air Density")
            tvchg2.setText("-> Wind Speed")
            tvchg3.setText("-> No of Blades")
        }
        if(typep == "GeoT"){
            tvpname.setText("Geo Thermal Plant")
            tvchg0.setText("-> Soiling")
            tvchg1.setText("-> Moisture")
            tvchg2.visibility = View.GONE
            tvchg3.visibility = View.GONE
        }

        button5.setOnClickListener {
            buy(it)
        }

    }
    fun buy(view: View)
    {
        Toast.makeText(applicationContext,"Oye!",Toast.LENGTH_SHORT).show()
        view.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            //set title for alert dialog

            builder.setTitle("Add Stack to subscription")
            //set message for alert dialog
            builder.setMessage("Are you Sure to add "+ typep + " Stack to your Subscription")
            builder.setIcon(R.drawable.ic_twotone_warning)

            //performing positive action
            builder.setPositiveButton("Yes"){dialogInterface, which ->
                Toast.makeText(applicationContext,"Added to Subscription",Toast.LENGTH_SHORT).show()

                if(typep == "Solar"){



                }
                if(typep == "geoT"){



                }

                if(typep == "Wind"){



                }

                val Int = Intent(application, DashBoard::class.java)
                startActivity(Int)
            }
            //performing cancel action
            builder.setNeutralButton("Cancel"){dialogInterface , which ->
                Toast.makeText(applicationContext,"Aborting!",Toast.LENGTH_SHORT).show()
            }
            //performing negative action
            builder.setNegativeButton("No"){dialogInterface, which ->
                Toast.makeText(applicationContext,"Cancelling the Subscription",Toast.LENGTH_SHORT).show()
            }
            val alertDialog: AlertDialog = builder.create()
            // Set other dialog properties
            alertDialog.setCancelable(false)
            alertDialog.show()
        }

    }
}