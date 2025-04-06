package com.halulkin.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.halulkin.designsystem.theme.GalleryTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    modifier: Modifier = Modifier,
    title: String? = null,
    onBackButtonClick: (() -> Unit)? = null,
    actionButton: @Composable (() -> Unit)? = null,
) {
    TopAppBar(
        modifier = modifier,
        title = {
            title?.let { Text(text = it) }
        },
        windowInsets = TopAppBarDefaults.windowInsets,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent,
            navigationIconContentColor = MaterialTheme.colorScheme.onSurface,
        ),
        navigationIcon = {
            if (onBackButtonClick != null) {
                BackButton(onClick = onBackButtonClick)
            }
        },
        actions = {
            actionButton?.invoke()
        },
    )
}

@Composable
private fun BackButton(onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "back",
        )
    }
}

@Composable
@Preview(name = "App Top Bar - Default")
private fun PreviewAppTopBar() {
    GalleryTheme {
        AppTopBar(title = "Top Bar")
    }
}

@Composable
@Preview(name = "App Top Bar - Back Button Shown")
private fun PreviewAppTopBarWithBackButton() {
    GalleryTheme {
        AppTopBar(
            title = "Top Bar",
            onBackButtonClick = { },
        )
    }
}
