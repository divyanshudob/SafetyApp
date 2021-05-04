package com.example.safetyapp

import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.view.Gravity
import android.widget.Button
import android.widget.Toast
import java.lang.Math.sqrt
import java.util.*

class alert_page : AppCompatActivity() {
    private var sensorManager: SensorManager? = null
    private var acceleration = 0f
    private var currentAcceleration = 0f
    private var lastAcceleration = 0f
   // val police = findViewById<Button>(R.id.police)
   // val helpline = findViewById<Button>(R.id.helpline)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert_page)
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        Objects.requireNonNull(sensorManager)!!.registerListener(sensorListener, sensorManager!!
            .getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL)
        acceleration = 10f
        currentAcceleration = SensorManager.GRAVITY_EARTH
        lastAcceleration = SensorManager.GRAVITY_EARTH

        /*police.setOnClickListener{

            val mobile = "100"
            val i = Intent()
            i.action =Intent.ACTION_DIAL
            i.data = Uri.parse("tel:$mobile")
            startActivity(i)
        }

        helpline.setOnClickListener{
            val mobile = "1096"
            val i = Intent()
            i.action =Intent.ACTION_DIAL
            i.data = Uri.parse("tel:$mobile")
            startActivity(i)

        }*/

    }
    private val sensorListener: SensorEventListener = object : SensorEventListener {
        override fun onSensorChanged(event: SensorEvent) {
            val x = event.values[0]
            val y = event.values[1]
            val z = event.values[2]
            lastAcceleration = currentAcceleration
            currentAcceleration = kotlin.math.sqrt((x * x + y * y + z * z).toDouble()).toFloat()
            val delta: Float = currentAcceleration - lastAcceleration
            acceleration = acceleration * 0.9f + delta
            if (acceleration > 12) {

                val myIntent = Intent(this@alert_page,MapsActivity::class.java)
                startActivity(myIntent)
                Toast.makeText(applicationContext,"SMS SENT",Toast.LENGTH_SHORT).show()

            }
            else{
                val myIntent = Intent(this@alert_page,defence_tips::class.java)
            }
        }
        override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {}
    }
    override fun onResume() {
        sensorManager?.registerListener(sensorListener, sensorManager!!.getDefaultSensor(
            Sensor .TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL
        )
        super.onResume()
    }
    override fun onPause() {
        sensorManager!!.unregisterListener(sensorListener)
        super.onPause()
    }


}