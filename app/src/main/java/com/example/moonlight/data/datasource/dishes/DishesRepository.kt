package com.example.moonlight.data.datasource.dishes

import com.example.moonlight.data.model.Dish
import com.example.moonlight.data.model.ResultState

interface DishesRepository {
    suspend fun getDishes(): ResultState<List<Dish>>
}