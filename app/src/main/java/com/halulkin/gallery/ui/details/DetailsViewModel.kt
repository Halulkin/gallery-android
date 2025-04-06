package com.halulkin.gallery.ui.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    companion object {
        const val URL_KEY = "url"
    }

    private val url: String = checkNotNull(savedStateHandle[URL_KEY])

    private val _stateFlow: MutableStateFlow<DetailsState> = MutableStateFlow(DetailsState())
    val stateFlow: StateFlow<DetailsState> = _stateFlow.asStateFlow()

    init {
        _stateFlow.update { it.copy(url = url) }
    }

}