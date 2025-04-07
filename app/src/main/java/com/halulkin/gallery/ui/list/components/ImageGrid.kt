package com.halulkin.gallery.ui.list.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.halulkin.gallery.domain.model.Image

@Composable
fun ImageGrid(
    images: List<Image>,
    searchTags: List<String>,
    onImageClick: (String) -> Unit,
) {
    val verticalPadding by animateDpAsState(
        targetValue = if (searchTags.isNotEmpty()) 170.dp else 120.dp
    )

    LazyVerticalStaggeredGrid(
        contentPadding = PaddingValues(vertical = verticalPadding, horizontal = 8.dp),
        columns = StaggeredGridCells.Fixed(2),
        verticalItemSpacing = 8.dp,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(images) { image ->
            ImageWithTitle(
                image = image,
                onImageClick = onImageClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .clip(RoundedCornerShape(12.dp))
                    .background(MaterialTheme.colorScheme.surfaceContainer)
                    .clickable { onImageClick(image.url) }
            )
        }
    }
}