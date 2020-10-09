package com.ps3.rem

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class IntroPage : AppCompatActivity() {

    var gs: Button?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ac_intropage)

        gs = findViewById(R.id.btngs)

        }

    public fun getsetgo(view: View){

        view.setOnClickListener {
            val int = Intent(applicationContext, SignUI::class.java)
            startActivity(int)
        }

    }

}