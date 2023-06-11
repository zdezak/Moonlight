package com.example.moonlight.domain.usecase

import com.example.moonlight.data.datasource.CategoryRepository
import com.example.moonlight.data.model.Category
import com.example.moonlight.data.model.ResultState
import kotlinx.coroutines.delay
import javax.inject.Inject

class GetCategoriesImpl @Inject constructor(
    private val categoryRepository: CategoryRepository,
) : GetCategories {
    override suspend fun invoke(): ResultState<List<Category>> {
        return categoryRepository.getCategory()
    }
}