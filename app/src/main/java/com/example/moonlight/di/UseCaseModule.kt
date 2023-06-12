package com.example.moonlight.di

import com.example.moonlight.domain.usecase.GetCategories
import com.example.moonlight.domain.usecase.GetCategoriesImpl
import com.example.moonlight.domain.usecase.GetDishes
import com.example.moonlight.domain.usecase.GetDishesImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Suppress("unused")
@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun bindGetCategories(impl: GetCategoriesImpl): GetCategories

    @Binds
    abstract fun bindGetDishes(impl: GetDishesImpl): GetDishes

}