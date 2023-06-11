package com.example.moonlight.data.datasource

import com.example.moonlight.data.model.Category
import com.example.moonlight.data.model.ResultState

interface CategoryRepository {
    suspend fun getCategory(): ResultState<List<Category>>
}