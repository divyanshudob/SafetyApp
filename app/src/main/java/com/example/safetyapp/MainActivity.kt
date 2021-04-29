package com.example.safetyapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import com.example.safetyapp.Details




class MainActivity : AppCompatActivity() {

   final val AUTH_REQUEST_CODE = 7192
    lateinit var firebaseAuth:FirebaseAuth
    lateinit var listener: FirebaseAuth.AuthStateListener
    lateinit var providers: List<AuthUI.IdpConfig>

    override fun onStart(){
        super.onStart()
        firebaseAuth.addAuthStateListener(listener)

    }

    override fun onStop(){
        super.onStop()

        if(listener!=null){
            firebaseAuth.removeAuthStateListener(listener)
        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button2 = findViewById<Button>(R.id.button2)
        val defence = findViewById<Button>(R.id.Defence)
        val alert = findViewById<Button>(R.id.alert)

        button2.setOnClickListener{

            val myIntent = Intent(this, Details::class.java)
            startActivity(myIntent)
        }

        defence.setOnClickListener{

            val myIntent = Intent(this, defence_tips::class.java)
            startActivity(myIntent)
        }

        alert.setOnClickListener{

            val myIntent = Intent(this, alert_page::class.java)
            startActivity(myIntent)
        }

        init()
    }

    private fun init() {
      providers = arrayListOf(AuthUI.IdpConfig.PhoneBuilder().build(),
              AuthUI.IdpConfig.EmailBuilder().build())

        firebaseAuth = FirebaseAuth.getInstance()
        listener = object:FirebaseAuth.AuthStateListener{
            override fun onAuthStateChanged(p0: FirebaseAuth) {
                val user = p0.currentUser
                if(user!= null){
                    // Do something
                }

                else{
                    startActivityForResult(AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .setLogo(R.drawable.logo)
                        .build(),AUTH_REQUEST_CODE)
                }
            }

        }
    }




}