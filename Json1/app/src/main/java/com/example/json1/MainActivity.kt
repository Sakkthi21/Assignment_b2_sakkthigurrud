package com.example.json1

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private lateinit var fetchDataButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fetchDataButton = findViewById(R.id.fetchDataButton)
        fetchDataButton.setOnClickListener {
            fetchData()
        }
    }

    private fun fetchData() {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val response = RetrofitInstance.api.getPhotos()
                withContext(Dispatchers.Main) {
                    handleResponse(response)
                }
            } catch (e: IOException) {
                e.printStackTrace()
                // Handle network error
            } catch (e: HttpException) {
                e.printStackTrace()
                // Handle HTTP error
            }
        }
    }

    private fun handleResponse(photos: List<MarsPhoto>) {
        // Process the list of MarsPhotos
        for (photo in photos) {
            println("Photo ID: ${photo.id}, URL: ${photo.img_src}, Date: ${photo.earth_date}")
        }

        // Example: Update your UI here with the fetched data

        val resultTextView = findViewById<TextView>(R.id.textViewResult)
        val sb = StringBuilder()
        for (photo in photos) {
            sb.append("Photo ID: ${photo.id}\n")
            sb.append("URL: ${photo.img_src}\n")
            sb.append("Date: ${photo.earth_date}\n\n")
        }
        resultTextView.text = sb.toString()
    }
}
