package com.halulkin.gallery.extensions

fun String.toLargeFlickrImage(): String {
    return this.replace("_m.jpg", "_b.jpg")
}
