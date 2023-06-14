package com.example.moonlight.data.model

import com.squareup.moshi.Json

data class Categories(
    // не исправлять ошибка на бэкэнде
    @Json(name = "сategories")
    val items: List<Category>
)