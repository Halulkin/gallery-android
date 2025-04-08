package com.halulkin.gallery.data.persistence.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.halulkin.gallery.domain.model.Image

@Entity(tableName = "images")
data class ImageEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val url: String,
)

fun ImageEntity.toImage() = Image(
    title = title,
    url = url,
)

fun Image.toImageEntity() = ImageEntity(
    id = 0,
    title = title,
    url = url,
)