package com.example.safetyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class Details : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val phone_number = findViewById<TextView>(R.id.phone_number)
        val add = findViewById<Button>(R.id.add)
        add.setOnClickListener{

        }
    }




}