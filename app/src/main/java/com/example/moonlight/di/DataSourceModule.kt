package com.example.moonlight.di

import com.example.moonlight.data.datasource.remote.CategoryDataSource
import com.example.moonlight.data.datasource.remote.CategoryDataSourceImpl
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

}