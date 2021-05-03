package com.example.safetyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class Details : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val Add = findViewById<Button>(R.id.add)
        val phoneNo = findViewById<EditText>(R.id.PhoneNumber)
        Add.setOnClickListener{
            if(phoneNo.toString()== null)
            {
                Toast.makeText(this,"Phone Number can't be Null", Toast.LENGTH_SHORT).show()
            }

            else {
                Toast.makeText(this, "Number Added", Toast.LENGTH_SHORT).show()
            }
        }


    }

}