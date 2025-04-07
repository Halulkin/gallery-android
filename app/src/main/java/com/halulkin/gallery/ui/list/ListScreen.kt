package com.halulkin.gallery.ui.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.halulkin.gallery.ui.list.components.ImageGrid
import com.halulkin.gallery.ui.list.components.ImagesSearchBar

@Composable
fun ListScreen(
    state: ListState,
    actions: ListActions,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        ImageGrid(
            images = state.images,
            searchTags = state.searchTags,
            onImageClick = actions.onImageClick
        )

        ImagesSearchBar(
            query = state.query,
            tags = state.searchTags,
            onQueryChange = actions.onQueryChange,
            onAddTag = actions.onAddTag,
            onRemoveTag = actions.onRemoveTag,
            modifier = Modifier
                .align(TopCenter)
                .fillMaxWidth()
        )
    }
}

@Composable
@Preview(name = "ListScreen")
private fun ListScreenPreview() {
    ListScreen(
        state = ListState(),
        actions = ListActions(),
    )
}
