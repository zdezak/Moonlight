package com.example.moonlight.ui.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moonlight.data.model.DishLocal
import com.example.moonlight.data.model.ResultState
import com.example.moonlight.domain.usecase.GetDishesInCart
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val getDishesInCart: GetDishesInCart,
) : ViewModel() {
    private val _cartUiState = MutableStateFlow<CartUiState>(CartUiState.Loading)
    val cartUiState: StateFlow<CartUiState> = _cartUiState

    var sum = 0
    private var loadingJob: Job? = null

    init {
        loadDishes()
    }

    private fun loadDishes() {
        _cartUiState.value = CartUiState.Loading
        loadingJob?.cancel()
        loadingJob = viewModelScope.launch {
            val newCartUiState: CartUiState = when (val dishesResult = getDishesInCart()) {
                is ResultState.Success -> {
                    summa(dishesResult.data)
                    CartUiState.Success(dishesResult.data)

                }

                is ResultState.Error -> {
                    dishesResult.error
                        .takeUnless { it is CancellationException }
                        ?.let(CartUiState::Error)
                        ?: CartUiState.Loading
                }
            }

            _cartUiState.value = (newCartUiState)
        }
    }

    private fun summa(dishes: List<DishLocal>): Int {
        var summa: Int = 0
        dishes.let { dishesList ->
            for (dish in dishesList) {
                summa = dish.count * dish.price.toInt()
            }
        }
        return summa
    }

    fun plusDishes(id: String) {
        TODO("Not yet implemented")
    }

    fun minusDishes(id: String) {
        TODO("Not yet implemented")
    }
}