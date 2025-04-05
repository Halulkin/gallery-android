package com.halulkin.gallery.di

import com.halulkin.gallery.data.repository.ImagesRepositoryImpl
import com.halulkin.gallery.domain.repository.ImagesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    @Singleton
    fun providesImagesRepository(repository: ImagesRepositoryImpl): ImagesRepository
}
