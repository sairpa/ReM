package com.ps3.rem

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class IntroPage : AppCompatActivity() {

    var gs: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.ac_intropage)
        val status: Boolean? = getSharedPreferences(getString(R.string.loginstatus),Context.MODE_PRIVATE).getBoolean(getString(R.string.openstatus),false)
        gs = findViewById(R.id.btngs)

        gs!!.setOnClickListener {
            if (!status!!) {

                val sp = getSharedPreferences(getString(R.string.loginstatus), Context.MODE_PRIVATE)
                sp.edit().putBoolean(getString(R.string.openstatus), true).apply()
                Log.d("Summa sp",sp.toString())
            }
            val int = Intent(applicationContext, SignUI::class.java)
            startActivity(int)

        }

    }

    public fun getsetgo(view: View) {

        view.setOnClickListener {

            val status: Boolean? = getSharedPreferences(getString(R.string.loginstatus),Context.MODE_PRIVATE).getBoolean(getString(R.string.openstatus),false)

            if (!status!!) {

                val sp = getSharedPreferences(getString(R.string.loginstatus), Context.MODE_PRIVATE)
                sp.edit().putBoolean(getString(R.string.openstatus), true).apply()
            }
            val int = Intent(applicationContext, SignUI::class.java)
            startActivity(int)
        }

    }

}