package com.example.moonlight.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class DishLocal(
    @PrimaryKey
    val id: String,
    val name: String,
    val price: String,
    val count: Int = 0,
    val weight: String,
    val description: String,
    val image_url: String?
)