package com.example.moonlight.di

import com.example.moonlight.domain.usecase.GetCategories
import com.example.moonlight.domain.usecase.GetCategoriesImpl
import com.example.moonlight.domain.usecase.GetDishes
import com.example.moonlight.domain.usecase.GetDishesImpl
import com.example.moonlight.domain.usecase.GetDishesInCart
import com.example.moonlight.domain.usecase.GetDishesInCartImpl
import com.example.moonlight.domain.usecase.SetInCart
import com.example.moonlight.domain.usecase.SetInCartImpl
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

    @Binds
    abstract fun bindSetInCart(impl: SetInCartImpl): SetInCart

    @Binds
    abstract fun bindGetDishesInCart(impl: GetDishesInCartImpl): GetDishesInCart

}