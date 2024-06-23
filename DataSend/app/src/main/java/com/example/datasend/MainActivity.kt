package com.example.datasend

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnSignup: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnSignup = findViewById(R.id.btnSignup)

        btnSignup.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this@MainActivity, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else {
                // Pass data to another activity
                val intent = Intent(this@MainActivity, SecondActivity::class.java).apply {
                    putExtra("USERNAME", username)
                    putExtra("PASSWORD", password)
                }
                startActivity(intent)
            }
        }
    }
}
