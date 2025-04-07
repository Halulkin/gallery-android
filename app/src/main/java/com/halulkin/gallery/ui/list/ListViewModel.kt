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

    private val _stateFlow: MutableStateFlow<ListState> = MutableStateFlow(ListState())
    val stateFlow: StateFlow<ListState> = _stateFlow.asStateFlow()

    init {
        savedStateHandle.get<String>(TAG_KEY)
            ?.takeIf { it.isNotBlank() }
            ?.let { addTag(it) }
    }

    fun changeQuery(query: String) {
        _stateFlow.update { it.copy(query = query) }
    }

    fun addTag(tag: String) {
        if (tag.isBlank() || stateFlow.value.searchTags.contains(tag)) return

        _stateFlow.update {
            it.copy(searchTags = it.searchTags + tag, query = "")
        }
        loadImages()
    }

    fun removeTag(tag: String) {
        _stateFlow.update {
            it.copy(searchTags = it.searchTags - tag)
        }
        loadImages()
    }

    private fun loadImages() = viewModelScope.launch {
        val tags = stateFlow.value.searchTags
        if (tags.isEmpty()) return@launch

        _stateFlow.update { it.copy(isLoading = true, error = null) }

        getImagesByTagUseCase(tags.joinToString())
            .onSuccess { images ->
                _stateFlow.update {
                    it.copy(images = images, isLoading = false)
                }
            }
            .onFailure { error ->
                Timber.e(error)
                _stateFlow.update {
                    it.copy(isLoading = false, error = error.message)
                }
            }
    }

    companion object {
        const val TAG_KEY = "tag_key"
    }
}
