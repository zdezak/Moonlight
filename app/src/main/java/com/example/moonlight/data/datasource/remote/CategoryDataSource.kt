package com.example.moonlight.data.datasource.remote

import com.example.moonlight.data.model.Category
import com.example.moonlight.data.model.ResultState

interface CategoryDataSource {
    suspend fun getCategories(): ResultState<List<Category>>
}