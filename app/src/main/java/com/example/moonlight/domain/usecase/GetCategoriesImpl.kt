package com.example.moonlight.domain.usecase

import com.example.moonlight.data.datasource.categories.CategoryRepository
import com.example.moonlight.data.model.Category
import com.example.moonlight.data.model.ResultState
import javax.inject.Inject

class GetCategoriesImpl @Inject constructor(
    private val repository: CategoryRepository,
) : GetCategories {
    override suspend fun invoke(): ResultState<List<Category>> {
        return repository.getCategory()
    }
}