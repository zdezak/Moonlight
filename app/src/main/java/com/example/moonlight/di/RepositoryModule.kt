package com.example.moonlight.di

import com.example.moonlight.data.datasource.categories.CategoryRepository
import com.example.moonlight.data.datasource.categories.CategoryRepositoryImpl
import com.example.moonlight.data.datasource.dishes.DishesRepository
import com.example.moonlight.data.datasource.dishes.DishesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Suppress("unused")
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindCategoryRepository(impl: CategoryRepositoryImpl): CategoryRepository

    @Binds
    abstract fun bindCDishesRepository(impl: DishesRepositoryImpl): DishesRepository
}