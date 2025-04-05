package com.halulkin.gallery.data.repository

import com.halulkin.gallery.data.api.ImagesApi
import com.halulkin.gallery.data.api.dtos.ImageDto
import com.halulkin.gallery.data.api.dtos.toImage
import com.halulkin.gallery.domain.model.Image
import com.halulkin.gallery.domain.repository.ImagesRepository
import javax.inject.Inject

class ImagesRepositoryImpl @Inject constructor(
    private val imagesApi: ImagesApi,
) : ImagesRepository {

    override suspend fun getImagesByTag(tag: String): List<Image> {
        return imagesApi.getImagesByTag(tags = tag)
            .items
            .map(ImageDto::toImage)
    }
}