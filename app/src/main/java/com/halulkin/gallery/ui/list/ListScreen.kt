package com.halulkin.gallery.ui.list

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.halulkin.gallery.domain.model.Image
import com.halulkin.gallery.ui.list.components.ImageWithTitle
import com.halulkin.gallery.ui.list.components.ImagesSearchBar

@Composable
fun ListScreen(
    state: ListState,
    actions: ListActions,
) {
    ListScreenContent(
        query = state.query,
        images = state.images,
        searchTags = state.searchTags,
        onQueryChange = actions.onQueryChange,
        onSearch = actions.onSearch,
        onRemoveTag = actions.onRemoveTag,
        onImageClick = actions.onImageClick,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ListScreenContent(
    query: String,
    images: List<Image>,
    searchTags: List<String>,
    onQueryChange: (String) -> Unit,
    onSearch: (String) -> Unit,
    onRemoveTag: (String) -> Unit,
    onImageClick: (String) -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
    ) {
        val verticalPadding by animateDpAsState(
            targetValue = if (searchTags.isNotEmpty()) 170.dp else 120.dp,
        )
        LazyVerticalStaggeredGrid(
            contentPadding = PaddingValues(vertical = verticalPadding, horizontal = 8.dp),
            columns = StaggeredGridCells.Fixed(2),
            verticalItemSpacing = 8.dp,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            content = {
                items(images) { image ->
                    ImageWithTitle(
                        image = image,
                        onImageClick = onImageClick,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .clip(RoundedCornerShape(12.dp))
                            .background(MaterialTheme.colorScheme.surfaceContainer)
                            .clickable { onImageClick(image.url) },
                    )
                }
            },
            modifier = Modifier.fillMaxSize(),
        )
        ImagesSearchBar(
            query = query,
            onQueryChange = onQueryChange,
            onSearch = onSearch,
            tags = searchTags,
            onRemoveTag = onRemoveTag,
            modifier = Modifier
                .align(TopCenter)
                .fillMaxWidth(),
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
