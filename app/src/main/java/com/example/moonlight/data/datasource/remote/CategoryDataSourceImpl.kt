package com.example.moonlight.data.datasource.remote

import com.example.moonlight.data.api.CategoryApiClient
import com.example.moonlight.data.model.Category
import com.example.moonlight.data.model.ResultState
import javax.inject.Inject

class CategoryDataSourceImpl @Inject constructor(
    private val apiClient: CategoryApiClient,
) : CategoryDataSource {
    override suspend fun getCategories(): ResultState<List<Category>> {
        val data = apiClient.getCategories().items
        return ResultState.Success(data)
    }
}