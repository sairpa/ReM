package com.ps3.rem

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import kotlinx.android.synthetic.main.activity_dash_board.*
import kotlin.random.Random


class DashBoard : AppCompatActivity() {

    var mAuth: FirebaseAuth? = null
    var mAuthList: FirebaseAuth.AuthStateListener? = null
    var id:String? = null
    lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)

        mAuth = FirebaseAuth.getInstance()
        mAuthList = FirebaseAuth.AuthStateListener {  }
        database = Firebase.database.reference
        getId()
        getDataforpown()
        getDataforStats()
        getDataforGraph()
        Toastmaker()
        tvd13.setOnClickListener {
         Toast.makeText(applicationContext,"Feature in Works!",Toast.LENGTH_SHORT).show()
            if (tvd13.text.toString() == "On" || tvd13.text.toString() == "on" ){

            }
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.option, menu)
        return super.onCreateOptionsMenu(menu)
    }

    fun getDataforGraph(){


        val prod = database.child("User").child(id.toString()).child("Products")
        prod.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                for (snap in snapshot.children) {
                    for (sna in snap.children) {
                        var graphview : GraphView = findViewById(R.id.gv_stats) as GraphView
                        var series = LineGraphSeries<DataPoint>()
                        var x = 0
                        var y = 0
                        for(i in 0..10){
                            x =i
                            val k = Math.random()*100
                            y = x*100 + k.toInt()
                            series.appendData(DataPoint(x.toDouble(),y.toDouble()),true,10)
                        }
                        series.backgroundColor = Color.MAGENTA
                        graphview.addSeries(series)

                    }
                }

            }

            override fun onCancelled(error: DatabaseError) {

            }

        })

    }

    fun getDataforStats(){

        val prod = database.child("User").child(id.toString()).child("Products")
        prod.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                for (snap in snapshot.children) {

                    if (snap.key.toString().equals("Solar")) {
                        for (sna in snap.children) {
                            tvs15.visibility = View.VISIBLE
                            tvs18.visibility = View.VISIBLE
                            tvs17.visibility = View.VISIBLE
                            tvs19.visibility = View.VISIBLE

                            tvs11.setText("Pid :" + sna.key.toString())
                            tvs12.setText(
                                "Energy generated :" + sna.child("energyg").getValue().toString()
                            )
                            tvs13.setText(
                                "Energy consumed :" + sna.child("getEnergyc").getValue().toString()
                            )
                            tvs14.setText(
                                "Efficiency :" + sna.child("efficiency").getValue().toString()
                            )
                            tvs15.setText(
                                "Sun Intensity " + sna.child("sunint").getValue().toString()
                            )
                            tvs16.setText(
                                "Temperature :" + sna.child("temperature").getValue().toString()
                            )
                            tvs17.setText(
                                "Cloud Cover :" + sna.child("cloudcover").getValue().toString()
                            )
                            tvs18.setText(
                                "Heat Build Up :" + sna.child("hbu").getValue().toString()
                            )
                            tvs19.setText("Soiling :" + sna.child("soiling").getValue().toString())
                            break
                        }
                        break
                    }
                    if (snap.key.toString().equals("Geo Thermal")) {
                        for (sna in snap.children) {

                            tvs15.visibility = View.VISIBLE
                            tvs18.visibility = View.VISIBLE

                            tvs11.setText("Pid" + sna.key.toString())
                            tvs12.setText(
                                "Energy generated :" + sna.child("energyg").getValue().toString()
                            )
                            tvs13.setText(
                                "Energy Consumed :" + sna.child("getEnergyc").getValue()
                                    .toString()
                            )
                            tvs14.setText(
                                "Effciency :" + sna.child("efficiency").getValue()
                                    .toString()
                            )
                            tvs15.setText(
                                "Soil Condition :" + sna.child("soiltype").getValue()
                                    .toString()
                            )
                            tvs16.setText(
                                "Temperature :" + sna.child("temperature").getValue()
                                    .toString()
                            )
                            tvs18.setText(
                                "Moisture Content :" + sna.child("moisture").getValue()
                                    .toString()
                            )
                            break
                        }
                        break
                    }

                    if (snap.key.toString().equals("Wind")) {
                        for (sna in snap.children) {

                            tvs15.visibility = View.VISIBLE
                            tvs18.visibility = View.VISIBLE


                            tvs11.setText("Pid :"+ sna.key.toString())
                            tvs12.setText(
                                "Energy generated :"+ sna.child("energyg").getValue().toString()
                            )
                            tvs13.setText(
                                "Energy consumed" + sna.child("getEnergyc").getValue()
                                    .toString()
                            )
                            tvs14.setText(
                                "Efficiency :" + sna.child("efficiency").getValue()
                                    .toString()
                            )
                            tvs15.setText(
                                "Windspeed :"+ sna.child("windspeed").getValue()
                                    .toString()
                            )
                            tvs16.setText(
                                "Temperature :"+ sna.child("temperature").getValue()
                                    .toString()
                            )
                            tvs18.setText(
                                 "Air Density :" + sna.child("airdensity").getValue()
                                    .toString()
                            )
                            break
                        }
                        break
                    }


                }
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })


    }

    fun getDataforpown(){
            tvd11.setText("")
            tvd12.setText("")
            tvd13.setText("")
            getId()
            val prod = database.child("User").child(id.toString()).child("Products")
            prod.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (snap in snapshot.children) {
                        if (snap.key.toString().equals("Solar")) {
                            for (sna in snap.children) {
                                tvd11.setText(sna.key.toString())
                                tvd12.setText("Solar")
                                tvd13.setText(sna.child("status").getValue().toString())
                                break
                            }
                        }
                        if (snap.key.toString().equals("Geo Thermal")) {
                            for (sna in snap.children) {
                                tvd11.setText(sna.key.toString())
                                tvd12.setText("Geo Thermal")
                                tvd13.setText(sna.child("status").getValue().toString())

                                break
                            }
                        }

                        if (snap.key.toString().equals("Wind")) {
                            for (sna in snap.children) {
                                tvd11.setText(sna.key.toString())
                                tvd12.setText("Wind")
                                tvd13.setText(sna.child("status").getValue().toString())
                                break
                            }
                        }


                    }
                }

                override fun onCancelled(error: DatabaseError) {

                }
            })
    }

    fun Toastmaker()
    {

        val prod = database.child("User").child(id.toString()).child("Products")
        prod.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (snap in snapshot.children) {
                        for (sna in snap.children) {
                            val msg = sna.child("status").getValue().toString()
                            if(msg == "Error")
                            {
                                Toast.makeText(applicationContext," Your Machines seems to be malfunctioned!",Toast.LENGTH_SHORT).show()
                            }
                            break
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })

    }

    fun getId()
    {

        val idrec = database.child("UserIDs")
        idrec.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                for (snap in snapshot.children) {
                    if (snap.getValue().toString().equals(mAuth!!.currentUser!!.email.toString())) {
                        id = snap.key.toString()
                    }
                }

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(applicationContext, " error", Toast.LENGTH_SHORT).show()
            }

        })

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == R.id.buy)
        {
            intent  = Intent(applicationContext, ProductList::class.java)
            intent.putExtra("ID", id)
            startActivity(intent)
        }

        if(item.itemId == R.id.signout){
            mAuth!!.signOut()
            Toast.makeText(applicationContext, "Signed Out", Toast.LENGTH_SHORT).show()
            val Int = Intent(applicationContext, SignUI::class.java)
            Int.putExtra("ID", id)
            startActivity(Int)
        }

        if(item.itemId == R.id.refresh){
            getId()
            getDataforpown()
            getDataforStats()
            getDataforGraph()
            Toastmaker()
        }

        if(item.itemId == R.id.about){
            val int = Intent(applicationContext, Devs::class.java)
            startActivity(int)
        }

        return super.onOptionsItemSelected(item)
    }


}