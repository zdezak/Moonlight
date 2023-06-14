package com.example.moonlight.data.model

import com.squareup.moshi.Json

data class Dishes(
    @Json(name = "dishes")
    val dishes: List<Dish>
)
