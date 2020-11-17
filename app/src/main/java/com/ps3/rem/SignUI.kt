package com.ps3.rem
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.ps3.rem.Classes.User_C
import kotlinx.android.synthetic.main.activity_sign_u_i.*

class SignUI : AppCompatActivity() {

    var btnsu: Button?= null
    var btnsubmit: Button?= null
    var etemail:EditText?=null
    var etpsswd:EditText?=null
    var mAuth: FirebaseAuth? = null
    var mAuthList: FirebaseAuth.AuthStateListener? = null
    lateinit var idUsr:String
    lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_u_i)

        btnsubmit = findViewById(R.id.btnsub)
        btnsu = findViewById(R.id.btnsu)
        etemail = findViewById(R.id.etemailt)
        etpsswd = findViewById(R.id.etpasswd)

        etname.text.clear()
        etphone.text.clear()
        etemail!!.text.clear()
        etpasswd!!.text.clear()
        etpsswdcfm.text.clear()
        etaddrs.text.clear()
        etpincd.text.clear()
        etusrid.text.clear()


         database = Firebase.database.reference
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
            tvtitle.setText("Sign Up")
            etusrid.visibility = View.VISIBLE
            etpsswdcfm.visibility = View.VISIBLE
            etaddrs.visibility = View.VISIBLE
            etpincd.visibility = View.VISIBLE
            etphone.visibility = View.VISIBLE
            etname.visibility = View.VISIBLE
            btnsu!!.visibility = View.GONE

        }
    }
        fun signIn(view: View) {
                if(btnsu!!.visibility == View.GONE){

                    signUp(view)
                    if (!etemail!!.text.isEmpty() && !etpsswd!!.text.isEmpty() && !etusrid.text.isEmpty() &&
                        !(etpsswdcfm.text.equals(etpsswd!!.text)) && !etaddrs.text.isEmpty() && !etpincd.text.isEmpty() && etphone.text.isNotBlank() && etname.text.isNotBlank()) {

                        mAuth!!.createUserWithEmailAndPassword(
                            etemail!!.text.toString(),
                            etpsswd!!.text.toString()
                        ).addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                Toast.makeText(
                                    applicationContext,
                                    "User Created:)",
                                    Toast.LENGTH_LONG
                                )
                                    .show()
                                Toast.makeText(
                                    applicationContext,
                                    "Signed In 😁",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                                Log.v("Status",etusrid.text.toString())
                                val usrid = database.child("UserIDs").child(etusrid.text.toString())
                                usrid.setValue(etusrid.text.toString())

                                idUsr = etusrid.text.toString()

                                val usrinfo = database.child("User").child(etusrid.text.toString())
                                val k = User_C(etname.text.toString(),etphone.text.toString(), etaddrs.text.toString(), etpincd.text.toString(), etemailt.text.toString())
                                usrinfo.setValue(k)

                                val intent = Intent(applicationContext, DashBoard::class.java)
                                intent.putExtra("ID", idUsr)
                                startActivity(intent)
                            }
                        }.addOnFailureListener { exception ->
                            Toast.makeText(
                                applicationContext,
                                exception.localizedMessage!!.toString(),
                                Toast.LENGTH_LONG
                            ).show()
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
                                Toast.makeText(
                                    applicationContext,
                                    exception.localizedMessage,
                                    Toast.LENGTH_LONG
                                ).show()
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