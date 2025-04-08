package com.halulkin.gallery.di

import android.content.Context
import androidx.room.Room
import com.halulkin.gallery.data.persistence.ImagesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context,
    ): ImagesDatabase {
        return Room.databaseBuilder(
            context,
            ImagesDatabase::class.java, "Images.db"
        ).build()
    }

    @Provides
    fun provideImageDao(database: ImagesDatabase) = database.imagesDao()
}