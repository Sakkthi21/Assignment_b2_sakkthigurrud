package com.example.detailsapp


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etPassword: EditText
    private lateinit var etAge: EditText
    private lateinit var radioGroupGender: RadioGroup
    private lateinit var radioButtonMale: RadioButton
    private lateinit var radioButtonFemale: RadioButton
    private lateinit var checkBoxReading: CheckBox
    private lateinit var checkBoxSports: CheckBox
    private lateinit var checkBoxMusic: CheckBox
    private lateinit var btnSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etName = findViewById(R.id.et_name)
        etPassword = findViewById(R.id.et_password)
        etAge = findViewById(R.id.et_age)
        radioGroupGender = findViewById(R.id.radio_group_gender)
        radioButtonMale = findViewById(R.id.radio_male)
        radioButtonFemale = findViewById(R.id.radio_female)
        checkBoxReading = findViewById(R.id.checkbox_reading)
        checkBoxSports = findViewById(R.id.checkbox_sports)
        checkBoxMusic = findViewById(R.id.checkbox_music)
        btnSubmit = findViewById(R.id.btn_submit)

        btnSubmit.setOnClickListener {
            handleSubmit()
        }
    }

    private fun handleSubmit() {
        val name = etName.text.toString().trim()
        val password = etPassword.text.toString().trim()
        val age = etAge.text.toString().trim()

        if (name.isEmpty() || password.isEmpty() || age.isEmpty()) {

            etName.error = if (name.isEmpty()) "Name is required" else null
            etPassword.error = if (password.isEmpty()) "Password is required" else null
            etAge.error = if (age.isEmpty()) "Age is required" else null
            return
        }

        val gender = when (radioGroupGender.checkedRadioButtonId) {
            R.id.radio_male -> "Male"
            R.id.radio_female -> "Female"
            else -> ""
        }

        if (gender.isEmpty()) {

            return
        }

        val hobbies = mutableListOf<String>()
        if (checkBoxReading.isChecked) {
            hobbies.add("Reading")
        }
        if (checkBoxSports.isChecked) {
            hobbies.add("Sports")
        }
        if (checkBoxMusic.isChecked) {
            hobbies.add("Music")
        }

        if (hobbies.isEmpty()) {

            return
        }

        val intent = Intent(this, DisplayActivity::class.java).apply {
            putExtra("name", name)
            putExtra("age", age)
            putExtra("gender", gender)
            putExtra("hobbies", hobbies.joinToString(", "))
        }
        startActivity(intent)
    }
}
