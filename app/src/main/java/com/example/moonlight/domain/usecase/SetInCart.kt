package com.example.moonlight.domain.usecase

import com.example.moonlight.data.model.Dish

interface SetInCart {
    suspend fun invoke(dish: Dish)
}