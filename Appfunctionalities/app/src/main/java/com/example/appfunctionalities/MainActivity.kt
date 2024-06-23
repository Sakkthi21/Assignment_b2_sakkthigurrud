package com.example.appfunctionalities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etUrl: EditText
    private lateinit var btnOpenWebPage: Button
    private lateinit var etEmail: EditText
    private lateinit var btnSendEmail: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etUrl = findViewById(R.id.etUrl)
        btnOpenWebPage = findViewById(R.id.btnOpenWebPage)
        etEmail = findViewById(R.id.etEmail)
        btnSendEmail = findViewById(R.id.btnSendEmail)

        btnOpenWebPage.setOnClickListener {
            val url = etUrl.text.toString()
            if (url.isNotEmpty()) {
                val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                if (webIntent.resolveActivity(packageManager) != null) {
                    startActivity(webIntent)
                } else {
                    Toast.makeText(this, "No application can handle this request. Please install a web browser.", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this, "Please enter a URL", Toast.LENGTH_SHORT).show()
            }
        }

        btnSendEmail.setOnClickListener {
            val email = etEmail.text.toString()
            if (email.isNotEmpty()) {
                val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:")
                    putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
                    putExtra(Intent.EXTRA_SUBJECT, "Subject Here")
                    putExtra(Intent.EXTRA_TEXT, "Body Here")
                }
                if (emailIntent.resolveActivity(packageManager) != null) {
                    startActivity(emailIntent)
                } else {
                    Toast.makeText(this, "No application can handle this request. Please install an email client.", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this, "Please enter an email address", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
