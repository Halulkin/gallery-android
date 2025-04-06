package com.halulkin.gallery.ui.details

data class DetailsState(
    val url: String = "",
)

data class DetailsActions(
    val onBackClick: () -> Unit = {},
)
