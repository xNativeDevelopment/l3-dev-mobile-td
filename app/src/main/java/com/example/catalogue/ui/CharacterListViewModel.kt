package com.example.catalogue.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.catalogue.domain.CharacterCatalog
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

// Le ViewModel écrit l'état ; l'écran ne peut que le lire.
class CharacterListViewModel(
    private val catalog: CharacterCatalog,
) : ViewModel() {
    private val _uiState =
        MutableStateFlow(CharacterListUiState())
    val uiState: StateFlow<CharacterListUiState> =
        _uiState.asStateFlow()

    init {
        load()
    }

    private fun load() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            val characters = withContext(Dispatchers.IO) {
                // Attente simulée d'un réseau lent, comme au TD 23.
                Thread.sleep(2_000)
                catalog.all()
            }
            // On remplace l'état avec copy : le flux voit un nouvel objet.
            _uiState.update {
                it.copy(characters = characters, isLoading = false)
            }
        }
    }
}
