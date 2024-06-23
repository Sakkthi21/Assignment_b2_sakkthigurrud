package com.example.datasend

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    private lateinit var tvWelcome: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        tvWelcome = findViewById(R.id.tvWelcome)

        // Get data from Intent
        val username = intent.getStringExtra("USERNAME")
        val password = intent.getStringExtra("PASSWORD")

        // Display the data
        tvWelcome.text = "Welcome, $username! Your password is: $password"
    }
}
