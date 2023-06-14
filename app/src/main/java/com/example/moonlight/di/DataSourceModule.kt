package com.example.moonlight.di

import com.example.moonlight.data.datasource.categories.remote.CategoryDataSource
import com.example.moonlight.data.datasource.categories.remote.CategoryDataSourceImpl
import com.example.moonlight.data.datasource.dishes.remote.DishesDataSource
import com.example.moonlight.data.datasource.dishes.remote.DishesDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Suppress("unused")
@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun bindCategoryRemoteDataSource(impl: CategoryDataSourceImpl): CategoryDataSource

    @Binds
    abstract fun bindDishesRemoteDataSource(impl: DishesDataSourceImpl): DishesDataSource

}