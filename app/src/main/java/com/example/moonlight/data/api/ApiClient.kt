package com.example.moonlight.data.api

import com.example.moonlight.data.model.Categories
import com.example.moonlight.data.model.Dishes
import retrofit2.http.GET

interface ApiClient {

    @GET("/v3/058729bd-1402-4578-88de-265481fd7d54")
    suspend fun getCategories(): Categories

    @GET("/v3/c7a508f2-a904-498a-8539-09d96785446e")
    suspend fun getDishes(): Dishes
}