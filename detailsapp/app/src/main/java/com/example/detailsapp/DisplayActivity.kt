package com.example.detailsapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DisplayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        val tvName: TextView = findViewById(R.id.tv_name)
        val tvAge: TextView = findViewById(R.id.tv_age)
        val tvGender: TextView = findViewById(R.id.tv_gender)
        val tvHobbies: TextView = findViewById(R.id.tv_hobbies)

        val name = intent.getStringExtra("name")
        val age = intent.getStringExtra("age")
        val gender = intent.getStringExtra("gender")
        val hobbies = intent.getStringExtra("hobbies")

        tvName.text = "Name: $name"
        tvAge.text = "Age: $age"
        tvGender.text = "Gender: $gender"
        tvHobbies.text = "Hobbies: $hobbies"
    }
}
