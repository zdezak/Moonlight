package com.example.moonlight.ui.cart

import com.example.moonlight.data.model.Dish
import com.example.moonlight.data.model.DishLocal

sealed class CartUiState {
    data class Success(val dishes: List<DishLocal>) : CartUiState()
    data class Error(val exception: Throwable) : CartUiState()
    object Loading : CartUiState()
}