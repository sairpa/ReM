package com.ps3.rem

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.ps3.rem.Classes.Geo_C
import com.ps3.rem.Classes.Solar_C
import com.ps3.rem.Classes.Wind_C
import kotlinx.android.synthetic.main.activity_product_details.*

class ProductDetails : AppCompatActivity() {
    lateinit var typep:String
    lateinit var database: DatabaseReference
    var id:String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)
        database = Firebase.database.reference
        typep = intent.getStringExtra("Type").toString()
        etpid.text.clear()
        id = intent.getStringExtra("ID")

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
        Toast.makeText(applicationContext, "Oye!", Toast.LENGTH_SHORT).show()
        view.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            //set title for alert dialog

            builder.setTitle("Add Stack to subscription")
            //set message for alert dialog
            builder.setMessage("Are you Sure to add " + typep + " Stack to your Subscription")
            builder.setIcon(R.drawable.ic_twotone_warning)

            //performing positive action
            builder.setPositiveButton("Yes"){ dialogInterface, which ->
                if(etpid.text.isNotEmpty()){
                    val pid = etpid.text.toString()
                    Toast.makeText(applicationContext, "Added to Subscription", Toast.LENGTH_SHORT).show()
                    val usrinfo = database.child("User").child(id!!.toString()).child("Products")
                    if(typep.equals("Solar")){

                        usrinfo.child("Solar").child(pid).setValue(Solar_C(pid,"Off","0","0%","50%","300MV","3MV","12","0","clear","100"))

                    }
                    if(typep.equals("GeoT") ){
                        Log.e("Iding","Why dude!?")
                        usrinfo.child("Geo Thermal").child(pid).setValue(Geo_C(pid, "off", "0", "0", "mushy", "250MV", "50MV", "50%"))

                    }

                    if(typep.equals("Wind") ){
                        Log.e("Iding","Why dude!? Wind")
                        usrinfo.child("Wind Plant").child(pid).setValue(Wind_C(pid, "off", "0", "0", "800MV", "2MV", "4","10kmph","30%","40m"))

                    }

                    val Int = Intent(application, DashBoard::class.java)
                    startActivity(Int)
                }


            }
            //performing cancel action
            builder.setNeutralButton("Cancel"){ dialogInterface, which ->
                Toast.makeText(applicationContext, "Aborting!", Toast.LENGTH_SHORT).show()
            }
            //performing negative action
            builder.setNegativeButton("No"){ dialogInterface, which ->
                Toast.makeText(
                    applicationContext,
                    "Cancelling the Subscription",
                    Toast.LENGTH_SHORT
                ).show()
            }
            val alertDialog: AlertDialog = builder.create()
            // Set other dialog properties
            alertDialog.setCancelable(false)
            alertDialog.show()
        }

    }
}