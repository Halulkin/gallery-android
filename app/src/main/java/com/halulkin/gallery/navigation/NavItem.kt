package com.halulkin.gallery.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface NavItem {
    @Serializable
    data object List : NavItem

    @Serializable
    data class Details(val url: String) : NavItem
}
