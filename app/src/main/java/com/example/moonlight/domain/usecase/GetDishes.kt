package com.example.moonlight.domain.usecase

import com.example.moonlight.data.model.Category
import com.example.moonlight.data.model.Dish
import com.example.moonlight.data.model.ResultState

interface GetDishes {
    suspend operator fun invoke(): ResultState<List<Dish>>
}