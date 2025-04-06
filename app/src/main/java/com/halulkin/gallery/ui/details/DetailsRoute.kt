package com.halulkin.gallery.ui.details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun DetailsRoute(
    onBackClick: () -> Unit,
    viewModel: DetailsViewModel = hiltViewModel(),
) {
    val uiState by viewModel.stateFlow.collectAsStateWithLifecycle()
    val actions = rememberDetailsActions(
        onBackClick = onBackClick,
        viewModel = viewModel,
    )
    DetailsScreen(uiState, actions)
}

@Composable
fun rememberDetailsActions(
    onBackClick: () -> Unit = {},
    viewModel: DetailsViewModel,
) = remember(viewModel) {
    DetailsActions(
        onBackClick = onBackClick,
    )
}
