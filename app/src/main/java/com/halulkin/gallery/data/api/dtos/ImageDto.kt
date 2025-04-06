package com.halulkin.gallery.data.api.dtos

import com.halulkin.gallery.domain.model.Image
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ImageDto(
    @SerialName("title") val title: String,
    @SerialName("link") val link: String,
    @SerialName("media") val media: MediaDto,
    @SerialName("date_taken") val dateTaken: String,
    @SerialName("description") val description: String,
    @SerialName("published") val published: String,
    @SerialName("author") val author: String,
    @SerialName("author_id") val authorId: String,
    @SerialName("tags") val tags: String,
)

fun ImageDto.toImage() = Image(
    title = title,
    url = media.link,
)
