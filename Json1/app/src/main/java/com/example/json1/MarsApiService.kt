package com.example.json1
import retrofit2.http.GET

interface MarsApiService {

    @GET("photos")
    suspend fun getPhotos(): List<MarsPhoto>
}
