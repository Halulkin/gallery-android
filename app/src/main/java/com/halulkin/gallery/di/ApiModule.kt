package com.halulkin.gallery.di

import com.halulkin.gallery.data.api.ImagesApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {
    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): ImagesApi {
        return retrofit.create(ImagesApi::class.java)
    }
}