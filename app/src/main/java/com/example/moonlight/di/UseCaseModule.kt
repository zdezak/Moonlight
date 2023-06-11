package com.example.moonlight.di

import com.example.moonlight.domain.usecase.GetCategories
import com.example.moonlight.domain.usecase.GetCategoriesImpl
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

}