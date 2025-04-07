package com.halulkin.gallery.ui.list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun ListRoute(
    onImageClick: (String) -> Unit,
    viewModel: ListViewModel = hiltViewModel(),
) {
    val uiState by viewModel.stateFlow.collectAsStateWithLifecycle()
    val actions = rememberListActions(
        onImageClick = onImageClick,
        viewModel = viewModel,
    )

    ListScreen(uiState, actions)
}

@Composable
fun rememberListActions(
    onImageClick: (String) -> Unit = {},
    viewModel: ListViewModel,
) = remember(viewModel) {
    ListActions(
        onQueryChange = viewModel::changeQuery,
        onAddTag = viewModel::addTag,
        onRemoveTag = viewModel::removeTag,
        onImageClick = onImageClick,
    )
}
