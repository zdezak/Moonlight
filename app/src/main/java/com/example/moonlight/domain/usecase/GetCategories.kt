package com.example.moonlight.domain.usecase

import com.example.moonlight.data.model.Category
import com.example.moonlight.data.model.ResultState

interface GetCategories {
    suspend operator fun invoke(): ResultState<List<Category>>
}