package com.ps3.rem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sign_u_i.*

class DashBoard : AppCompatActivity() {

    var mAuth: FirebaseAuth? = null
    var mAuthList: FirebaseAuth.AuthStateListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)

        mAuth = FirebaseAuth.getInstance()
        mAuthList = FirebaseAuth.AuthStateListener {  }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.option,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == R.id.buy)
        {
            intent  = Intent(applicationContext,ProductList::class.java)
            startActivity(intent)
        }

        if(item.itemId == R.id.signout){
            mAuth!!.signOut()
            Toast.makeText(applicationContext,"Signed Out",Toast.LENGTH_SHORT).show()
            val Int = Intent(applicationContext, SignUI::class.java)
            startActivity(Int)
        }

        return super.onOptionsItemSelected(item)
    }


}