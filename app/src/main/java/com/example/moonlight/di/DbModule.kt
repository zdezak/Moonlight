package com.example.moonlight.di

import android.content.Context
import androidx.room.Room
import com.example.moonlight.data.datasource.database.AppDatabase
import com.example.moonlight.data.datasource.database.DishDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DbModule {

    @Provides
    @Singleton
    fun provideRoom(@ApplicationContext context: Context): AppDatabase {
        return Room.inMemoryDatabaseBuilder(
            context,
            AppDatabase::class.java
        ).build()
    }

    @Provides
    @Singleton
    fun provideDishDao(appDatabase: AppDatabase): DishDao {
        return appDatabase.dishDao()
    }
}