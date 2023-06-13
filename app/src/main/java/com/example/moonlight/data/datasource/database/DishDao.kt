package com.example.moonlight.data.datasource.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moonlight.data.model.Dish
import com.example.moonlight.data.model.DishLocal

@Dao
interface DishDao {
    @Query("SELECT * FROM dishLocal")
    fun getAll(): List<DishLocal>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(dishLocal: DishLocal)

    @Delete
    suspend fun delete(dishLocal: DishLocal)

    @Query("SELECT * FROM dishLocal WHERE `count` > 0")
    suspend fun getInCartDishes(): List<DishLocal>
}