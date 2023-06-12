package com.example.moonlight.data.datasource.remote

import com.example.moonlight.data.api.CategoryApiClient
import com.example.moonlight.data.model.Category
import com.example.moonlight.data.model.ResultState
import kotlinx.coroutines.delay
import javax.inject.Inject

class CategoryDataSourceImpl @Inject constructor(
    private val apiClient: CategoryApiClient,
) : CategoryDataSource {
    override suspend fun getCategories(): ResultState<List<Category>> {
        delay(1500)
        val data = apiClient.getCategories().items
        return ResultState.Success(data)
    }
}