package com.example.moonlight.data.api

import com.example.moonlight.data.model.Categories
import retrofit2.http.GET

interface CategoryApiClient {

    @GET("/v3/058729bd-1402-4578-88de-265481fd7d54")
    suspend fun getCategories(): Categories
}