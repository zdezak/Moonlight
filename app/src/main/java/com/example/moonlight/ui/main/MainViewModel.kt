package com.example.moonlight.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moonlight.data.model.ResultState
import com.example.moonlight.domain.usecase.GetCategories
import com.example.moonlight.ui.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCategories: GetCategories,
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState

    private var loadingJob: Job? = null

    init {
        loadCategories()
    }

    private fun loadCategories() {
        _uiState.value = UiState.Loading
        loadingJob?.cancel()
        loadingJob = viewModelScope.launch {
            val newUiState: UiState = when (val categoriesResult = getCategories()) {
                is ResultState.Success -> {
                    UiState.Success(categoriesResult.data)
                }

                is ResultState.Error -> {
                    categoriesResult.error
                        .takeUnless { it is CancellationException }
                        ?.let(UiState::Error)
                        ?: UiState.Loading
                }
            }

            _uiState.value = (newUiState)
        }
    }
}