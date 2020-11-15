package com.ps3.rem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sign_u_i.*

class SignUI : AppCompatActivity() {
    var btnsu: Button?= null
    var btnsubmit: Button?= null
    var etemail:EditText?=null
    var etpsswd:EditText?=null
    var mAuth: FirebaseAuth? = null
    var mAuthList: FirebaseAuth.AuthStateListener? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_u_i)

        btnsubmit = findViewById(R.id.btnsub)
        btnsu = findViewById(R.id.btnsu)
        etemail = findViewById(R.id.etemail)
        etpsswd = findViewById(R.id.etpasswd)

        mAuth = FirebaseAuth.getInstance()
        mAuthList = FirebaseAuth.AuthStateListener {  }

        btnsu!!.setOnClickListener {
            signUp(it)
        }

        btnsubmit!!.setOnClickListener {
            signIn(it)
        }

    }

    fun signUp(view: View) {
        view.setOnClickListener {
            tvtitle.setText("Sign Up :)")
            etusrid.visibility = View.VISIBLE
            etpsswdcfm.visibility = View.VISIBLE
            etaddrs.visibility = View.VISIBLE
            etpincd.visibility = View.VISIBLE
            btnsu!!.visibility = View.GONE


        }
    }
        fun signIn(view: View) {
                if(btnsu!!.visibility == View.GONE){

                    signUp(view)
                    if (!etemail!!.text.isEmpty() && !etpsswd!!.text.isEmpty() && !etusrid.text.isEmpty() &&
                        !(etpsswdcfm.text.equals(etpsswd!!.text)) && !etaddrs.text.isEmpty() && !etpincd.text.isEmpty()) {
                        mAuth!!.createUserWithEmailAndPassword(
                            etemail!!.text.toString(),
                            etpsswd!!.text.toString()
                        ).addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                Toast.makeText(applicationContext, "User Created:)", Toast.LENGTH_LONG)
                                    .show()
                                Toast.makeText(applicationContext, "Signed In 😁", Toast.LENGTH_SHORT)
                                    .show()
                                val intent = Intent(applicationContext, DashBoard::class.java)
                                startActivity(intent)
                            }
                        }.addOnFailureListener { exception ->
                            if (exception != null) {
                                Toast.makeText(
                                    applicationContext,
                                    exception.localizedMessage!!.toString(),
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        }


                    }
                    else{
                        Toast.makeText(
                            applicationContext,
                            "Please enter all the fields to proceed!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                }
                else{

                    view.setOnClickListener {

                        if (!etemail!!.text.isEmpty() && !etpsswd!!.text.isEmpty()) {

                            mAuth!!.signInWithEmailAndPassword(
                                etemail!!.text.toString(),
                                etpsswd!!.text.toString()
                            ).addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    Toast.makeText(
                                        applicationContext,
                                        "Signed In 😁",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    val intent = Intent(applicationContext, DashBoard::class.java)
                                    startActivity(intent)
                                }

                            }.addOnFailureListener { exception ->
                                if (exception != null) {
                                    Toast.makeText(
                                        applicationContext,
                                        exception.localizedMessage,
                                        Toast.LENGTH_LONG
                                    ).show()
                                }
                            }

                        } else {
                            Toast.makeText(
                                applicationContext,
                                "Please enter all the fields to proceed!",
                                Toast.LENGTH_SHORT
                            ).show()
                        }


                    }
                }
            }
        }