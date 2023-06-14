package com.example.moonlight.data.datasource.dishes.remote

import com.example.moonlight.data.model.Dish
import com.example.moonlight.data.model.ResultState

interface DishesDataSource {
    suspend fun getDishes(): ResultState<List<Dish>>
}