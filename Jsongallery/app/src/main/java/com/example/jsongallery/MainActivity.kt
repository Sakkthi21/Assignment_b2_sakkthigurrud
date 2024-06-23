package com.example.jsongallery

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jsongallery.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var photoAdapter: PhotoAdapter
    private val apiService = ApiService.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        binding.showImageButton.setOnClickListener {
            fetchPhotos()
        }
    }

    private fun fetchPhotos() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val photos = apiService.getPhotos()
                withContext(Dispatchers.Main) {
                    photoAdapter = PhotoAdapter(photos)
                    binding.recyclerView.adapter = photoAdapter
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
