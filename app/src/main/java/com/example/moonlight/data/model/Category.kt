package com.example.moonlight.data.model

import com.squareup.moshi.Json

data class Category(
    @Json(name = "id")
    val id: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "image_url")
    val imageUrl: String
)
