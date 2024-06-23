package com.example.language

import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadLocale() // Load the saved language preference
        setContentView(R.layout.activity_main)

        val changeLang = findViewById<Button>(R.id.changeMyLang)
        changeLang.setOnClickListener {
            showChangeLanguageDialog()
        }
    }

    private fun showChangeLanguageDialog() {
        val listItems = arrayOf("French", "Hindi", "Urdu", "English")
        val mBuilder = AlertDialog.Builder(this@MainActivity)
        mBuilder.setTitle("Choose Language...")
        mBuilder.setSingleChoiceItems(listItems, -1) { dialogInterface, i ->
            when (i) {
                0 -> setLocale("fr")
                1 -> setLocale("hi")
                2 -> setLocale("ur")
                3 -> setLocale("en")
            }
            dialogInterface.dismiss()
            recreate()
        }
        val mDialog = mBuilder.create()
        mDialog.show()
    }

    private fun setLocale(lang: String) {
        val locale = Locale(lang)
        Locale.setDefault(locale)
        val config = resources.configuration
        config.setLocale(locale)
        resources.updateConfiguration(config, resources.displayMetrics)

        // Save data to shared preferences
        val editor: SharedPreferences.Editor = getSharedPreferences("Settings", MODE_PRIVATE).edit()
        editor.putString("My_Lang", lang)
        editor.apply()
    }

    private fun loadLocale() {
        val prefs: SharedPreferences = getSharedPreferences("Settings", MODE_PRIVATE)
        val language = prefs.getString("My_Lang", "")
        if (language != null && language.isNotEmpty()) {
            setLocale(language)
        }
    }
}
