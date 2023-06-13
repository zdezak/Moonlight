package com.example.moonlight.domain.usecase

import com.example.moonlight.data.datasource.database.DishDao
import com.example.moonlight.data.model.DishLocal
import com.example.moonlight.data.model.ResultState
import javax.inject.Inject

class GetDishesInCartImpl @Inject constructor(
    private val dishDao: DishDao,
) : GetDishesInCart {
    // TODO,Исправить и сделать через репозиторий и датосоурс
    override suspend fun invoke(): ResultState<List<DishLocal>> {
        return ResultState.Success(dishDao.getInCartDishes())
    }
}