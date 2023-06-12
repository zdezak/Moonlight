package com.example.moonlight.domain.usecase

import com.example.moonlight.data.datasource.categories.CategoryRepository
import com.example.moonlight.data.datasource.dishes.DishesRepository
import com.example.moonlight.data.model.Dish
import com.example.moonlight.data.model.ResultState
import javax.inject.Inject

class GetDishesImpl @Inject constructor(
    private val repository: DishesRepository,
) : GetDishes {
    override suspend fun invoke(): ResultState<List<Dish>> {
        return repository.getDishes()
    }
}