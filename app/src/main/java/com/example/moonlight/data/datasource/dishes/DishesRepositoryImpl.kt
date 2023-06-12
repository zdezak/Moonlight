package com.example.moonlight.data.datasource.dishes

import com.example.moonlight.data.datasource.categories.remote.CategoryDataSource
import com.example.moonlight.data.datasource.dishes.remote.DishesDataSource
import com.example.moonlight.data.model.Dish
import com.example.moonlight.data.model.ResultState
import javax.inject.Inject

class DishesRepositoryImpl @Inject constructor(
    private val remoteDataSource: DishesDataSource,
) : DishesRepository {
    override suspend fun getDishes(): ResultState<List<Dish>> {
        return remoteDataSource.getDishes()
    }
}