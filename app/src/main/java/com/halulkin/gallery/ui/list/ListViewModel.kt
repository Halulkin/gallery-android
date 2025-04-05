package com.halulkin.gallery.ui.list

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.halulkin.gallery.domain.usecase.GetImagesByTagUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val getImagesByTagUseCase: GetImagesByTagUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    companion object {
        const val TAG_KEY = "tag_key"
    }

    private val _stateFlow: MutableStateFlow<ListState> = MutableStateFlow(ListState())
    val stateFlow: StateFlow<ListState> = _stateFlow.asStateFlow()

    init {
        val tag = savedStateHandle.get<String>(TAG_KEY) ?: ""
        getImagesByTag(tag)
    }

    fun onQueryChange(query: String) {
        _stateFlow.update { it.copy(query = query) }
    }

    fun onSearch(query: String) {
        _stateFlow.update { it.copy(query = query) }
        getImagesByTag(query)
    }

    fun getImagesByTag(tag: String) = viewModelScope.launch {
        _stateFlow.update { it.copy(isLoading = true) }

        getImagesByTagUseCase(tag)
            .onSuccess { images ->
                _stateFlow.update {
                    it.copy(images = images, isLoading = false)
                }
            }
            .onFailure { error ->
                Timber.e("getImagesByTag: $error")
                _stateFlow.update {
                    it.copy(isLoading = false, error = error.message)
                }
            }
    }
}