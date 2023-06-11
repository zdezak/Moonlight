package com.example.moonlight.data.datasource

import com.example.moonlight.data.datasource.remote.CategoryDataSource
import com.example.moonlight.data.model.Category
import com.example.moonlight.data.model.ResultState
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val remoteDataSource: CategoryDataSource,
) : CategoryRepository {
    override suspend fun getCategory(): ResultState<List<Category>> {
        return remoteDataSource.getCategories()
    }
}