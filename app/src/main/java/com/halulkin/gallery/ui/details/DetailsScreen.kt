package com.halulkin.gallery.ui.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.halulkin.components.AppTopBar

@Composable
fun DetailsScreen(
    state: DetailsState,
    actions: DetailsActions
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
    ) {
        AsyncImage(
            model = state.url,
            contentDescription = "Image",
            modifier = Modifier.fillMaxSize()
        )
        AppTopBar(
            onBackButtonClick = actions.onBackClick,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
@Preview(name = "Details")
private fun DetailsScreenPreview() {
    DetailsScreen(
        state = DetailsState(),
        actions = DetailsActions()
    )
}

