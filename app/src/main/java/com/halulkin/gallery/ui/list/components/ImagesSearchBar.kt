package com.halulkin.gallery.ui.list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.halulkin.components.AppSearchBar

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ImagesSearchBar(
    query: String,
    tags: List<String>,
    onQueryChange: (String) -> Unit,
    onAddTag: (String) -> Unit,
    onRemoveTag: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(
                start = 16.dp,
                end = 16.dp,
                top = 42.dp,
                bottom = if (tags.isEmpty()) 16.dp else 8.dp,
            ),
    ) {
        AppSearchBar(
            query = query,
            onQueryChange = onQueryChange,
            onAddTag = onAddTag,
            placeholder = "Search images by tags...",
            leadingIcon = Icons.Default.Search,
            trailingIcon = Icons.Default.Close,
            modifier = Modifier.fillMaxWidth(),
        )

        TagsList(
            tags = tags,
            onRemoveTag = onRemoveTag,
        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun TagsList(
    tags: List<String>,
    onRemoveTag: (String) -> Unit,
    visible: Boolean = tags.isNotEmpty(),
) {
    if (!visible) return

    FlowRow(
        horizontalArrangement = Arrangement.Start,
        verticalArrangement = Arrangement.Center,
        maxItemsInEachRow = Int.MAX_VALUE,
        maxLines = 1,
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState()),
    ) {
        tags.forEach { tag ->
            AssistChip(
                onClick = {},
                label = { Text(tag) },
                modifier = Modifier.padding(end = 4.dp),
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = "Remove",
                        modifier = Modifier
                            .size(18.dp)
                            .clickable { onRemoveTag(tag) },
                    )
                },
            )
        }
    }
}
