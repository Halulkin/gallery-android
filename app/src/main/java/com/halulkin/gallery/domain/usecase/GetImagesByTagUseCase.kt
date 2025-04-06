package com.halulkin.gallery.domain.usecase

import com.halulkin.gallery.domain.repository.ImagesRepository
import javax.inject.Inject

class GetImagesByTagUseCase @Inject constructor(
    private val imagesRepository: ImagesRepository,
) {
    suspend operator fun invoke(tag: String) = runCatching {
        imagesRepository.getImagesByTag(tag)
    }
}
