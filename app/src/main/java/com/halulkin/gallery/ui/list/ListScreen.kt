package com.halulkin.gallery.ui.list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.halulkin.components.AppSearchBar
import com.halulkin.gallery.domain.model.Image
import com.halulkin.gallery.ui.list.components.ImageWithTitle

@Composable
fun ListScreen(
    state: ListState,
    actions: ListActions,
) {
    ListScreenContent(
        query = state.query,
        images = state.images,
        onQueryChange = actions.onQueryChange,
        onSearch = actions.onSearch,
        onImageClick = actions.onImageClick,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ListScreenContent(
    query: String,
    images: List<Image>,
    onQueryChange: (String) -> Unit,
    onSearch: (String) -> Unit,
    onImageClick: (String) -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
    ) {
        LazyVerticalStaggeredGrid(
            contentPadding = PaddingValues(vertical = 120.dp, horizontal = 8.dp),
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
                            .background(SearchBarDefaults.colors().containerColor)
                            .clickable { onImageClick(image.url) },
                    )
                }
            },
            modifier = Modifier.fillMaxSize(),
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .align(TopCenter)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.background,
                            MaterialTheme.colorScheme.background,
                            MaterialTheme.colorScheme.background,
                            Transparent,
                        ),
                        startY = 100f,
                        endY = 140f * LocalDensity.current.density,
                    ),
                ),
        )
        AppSearchBar(
            query = query,
            onQueryChange = onQueryChange,
            onSearch = onSearch,
            placeholder = "Search",
            leadingIcon = Icons.Default.Search,
            modifier = Modifier.align(TopCenter),
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
