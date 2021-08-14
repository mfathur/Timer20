package com.omahti.timer20

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStartTimer = findViewById<Button>(R.id.btn_start_timer)
        val btnResetTimer = findViewById<Button>(R.id.btn_reset_timer)
        val textTimer = findViewById<TextView>(R.id.timer)

        val timer = object : CountDownTimer(1000L * 60 * 20, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val minutes = millisUntilFinished / (1000 * 60)
                val seconds = (millisUntilFinished / 1000) % 60
                textTimer.text = minutes.toString() + ":" + seconds.toString()
            }

            override fun onFinish() {
                // show notification
            }

        }

        btnStartTimer.setOnClickListener {
            timer.start()
        }
        btnResetTimer.setOnClickListener {
            timer.cancel()
            textTimer.text = "20:00"
        }
    }
}