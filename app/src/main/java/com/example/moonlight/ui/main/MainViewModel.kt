package com.example.moonlight.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moonlight.data.model.ResultState
import com.example.moonlight.domain.usecase.GetCategories
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCategories: GetCategories,
) : ViewModel() {

    private val _mainUiState = MutableStateFlow<MainUiState>(MainUiState.Loading)
    val mainUiState: StateFlow<MainUiState> = _mainUiState

    private var loadingJob: Job? = null

    init {
        loadCategories()
    }

    private fun loadCategories() {
        _mainUiState.value = MainUiState.Loading
        loadingJob?.cancel()
        loadingJob = viewModelScope.launch {
            val newMainUiState: MainUiState = when (val categoriesResult = getCategories()) {
                is ResultState.Success -> {
                    MainUiState.Success(categoriesResult.data)
                }

                is ResultState.Error -> {
                    categoriesResult.error
                        .takeUnless { it is CancellationException }
                        ?.let(MainUiState::Error)
                        ?: MainUiState.Loading
                }
            }

            _mainUiState.value = (newMainUiState)
        }
    }
}