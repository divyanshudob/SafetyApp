package com.example.safetyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class Details : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val Add = findViewById<Button>(R.id.add)
        Add.setOnClickListener{
            Toast.makeText(this,"Number Added",Toast.LENGTH_SHORT).show()
        }


    }

}