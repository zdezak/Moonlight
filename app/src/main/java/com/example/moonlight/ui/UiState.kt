package com.example.moonlight.ui

import com.example.moonlight.data.model.Category

sealed class UiState {
    data class Success(val Categories: List<Category>) : UiState()
    data class Error(val exception: Throwable) : UiState()
    object Loading : UiState()
}