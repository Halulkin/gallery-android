package com.halulkin.gallery.data.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.halulkin.gallery.data.persistence.dao.ImagesDao
import com.halulkin.gallery.data.persistence.entity.ImageEntity

@Database(entities = [ImageEntity::class], version = 1)
abstract class ImagesDatabase : RoomDatabase() {
    abstract fun imagesDao(): ImagesDao
}
