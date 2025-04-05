package com.halulkin.gallery.extension

fun String.toLargeFlickrImage(): String {
    return this.replace("_m.jpg", "_b.jpg")
}