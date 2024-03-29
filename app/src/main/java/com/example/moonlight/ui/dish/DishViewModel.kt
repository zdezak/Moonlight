package com.example.moonlight.ui.dish

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moonlight.data.model.Dish
import com.example.moonlight.data.model.ResultState
import com.example.moonlight.domain.usecase.GetDishes
import com.example.moonlight.domain.usecase.SetInCart
import com.example.moonlight.ui.category.CategoryUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DishViewModel @Inject constructor(
    private val getDishes: GetDishes,
    private val setInCart: SetInCart,
) : ViewModel() {
    private val _categoryUiState = MutableStateFlow<CategoryUiState>(CategoryUiState.Loading)
    val categoryUiState: StateFlow<CategoryUiState> = _categoryUiState

    private var dishId = -1
    private var loadingJob: Job? = null

    init {
        loadDishes()
    }

    private fun loadDishes() {
        _categoryUiState.value = CategoryUiState.Loading
        loadingJob?.cancel()
        loadingJob = viewModelScope.launch {
            val newCategoryUiState: CategoryUiState = when (val dishesResult = getDishes()) {
                is ResultState.Success -> {
                    CategoryUiState.Success(dishesResult.data)
                }

                is ResultState.Error -> {
                    dishesResult.error
                        .takeUnless { it is CancellationException }
                        ?.let(CategoryUiState::Error)
                        ?: CategoryUiState.Loading
                }
            }

            _categoryUiState.value = (newCategoryUiState)
        }
    }

    fun setDishIndex(id: String) {
        dishId = id.toInt() - 1
    }

    fun getDishIndex(): Int {
        return dishId
    }

    fun setInCart(dish: Dish) {
        loadingJob?.cancel()
        loadingJob = viewModelScope.launch(Dispatchers.IO) {
            setInCart.invoke(dish = dish)
        }
    }
}