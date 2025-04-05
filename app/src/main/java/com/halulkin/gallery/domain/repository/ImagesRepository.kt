package com.halulkin.gallery.domain.repository

import com.halulkin.gallery.domain.model.Image

interface ImagesRepository {
    suspend fun getImagesByTag(tag: String): List<Image>
}