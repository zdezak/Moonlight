package com.example.moonlight.data.datasource.dishes.remote

import com.example.moonlight.data.api.ApiClient
import com.example.moonlight.data.model.Dish
import com.example.moonlight.data.model.ResultState
import kotlinx.coroutines.delay
import javax.inject.Inject

class DishesDataSourceImpl @Inject constructor(
    private val apiClient: ApiClient,
) : DishesDataSource {
    override suspend fun getDishes(): ResultState<List<Dish>> {
        delay(1500)
        val data = apiClient.getDishes().dishes
        return ResultState.Success(data)
    }
}