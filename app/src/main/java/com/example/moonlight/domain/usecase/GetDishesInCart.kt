package com.example.moonlight.domain.usecase

import com.example.moonlight.data.model.DishLocal
import com.example.moonlight.data.model.ResultState

interface GetDishesInCart {
    suspend operator fun invoke(): ResultState<List<DishLocal>>
}