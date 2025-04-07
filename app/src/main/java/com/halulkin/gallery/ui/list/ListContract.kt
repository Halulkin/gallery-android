package com.halulkin.gallery.ui.list

import com.halulkin.gallery.domain.model.Image

data class ListState(
    val query: String = "",
    val searchTags: List<String> = emptyList(),
    val images: List<Image> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
)

data class ListActions(
    val onQueryChange: (String) -> Unit = {},
    val onRemoveTag: (String) -> Unit = {},
    val onSearch: (String) -> Unit = {},
    val onImageClick: (String) -> Unit = {},
)
