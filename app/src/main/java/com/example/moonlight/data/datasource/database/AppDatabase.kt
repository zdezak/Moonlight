package com.example.moonlight.data.datasource.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.moonlight.data.model.DishLocal

@Database(entities = [DishLocal::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dishDao(): DishDao
}