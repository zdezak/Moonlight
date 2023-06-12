package com.example.moonlight.ui.category

import com.example.moonlight.data.model.Dish

sealed class CategoryUiState {
    data class Success(val dishes: List<Dish>) : CategoryUiState()
    data class Error(val exception: Throwable) : CategoryUiState()
    object Loading : CategoryUiState()
}