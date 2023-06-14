package com.example.moonlight.domain.usecase

import com.example.moonlight.data.datasource.database.DishDao
import com.example.moonlight.data.model.Dish
import com.example.moonlight.data.model.DishLocal
import javax.inject.Inject

class SetInCartImpl @Inject constructor(
    private val dishDao: DishDao,
) : SetInCart {

    override suspend fun invoke(dish: Dish) {
        var dishLocal: DishLocal
        if (dishDao.isDishInCart(dish.id)) {
            dishLocal = dishDao.getDishById(dish.id)
            dishLocal = dishLocal.copy(count = dishLocal.count + 1)
        } else {
            dish.let {
                dishLocal = DishLocal(
                    id = dish.id,
                    name = dish.name,
                    price = dish.price,
                    count = 1,
                    weight = dish.weight,
                    description = dish.description,
                    image_url = dish.image_url
                )
                dishDao.insert(dishLocal)
            }
            dishDao.insert(dishLocal)
        }

    }
}


