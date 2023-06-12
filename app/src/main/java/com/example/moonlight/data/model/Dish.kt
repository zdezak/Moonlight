package com.example.moonlight.data.model

import com.squareup.moshi.Json

data class Dish(
    @Json(name = "id")
    val id: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "price")
    val price: String,
    @Json(name = "weight")
    val weight: String,
    @Json(name = "description")
    val description: String,
    @Json(name = "image_url")
    val image_url: String?,
    @Json(name = "tegs")
    val tags: List<String>,
)
