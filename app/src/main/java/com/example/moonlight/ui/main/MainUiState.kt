package com.example.moonlight.ui.main

import com.example.moonlight.data.model.Category

sealed class MainUiState {
    data class Success(val Categories: List<Category>) : MainUiState()
    data class Error(val exception: Throwable) : MainUiState()
    object Loading : MainUiState()
}