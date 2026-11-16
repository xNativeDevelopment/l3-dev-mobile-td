package com.example.catalogue.ui

import androidx.lifecycle.ViewModel
import com.example.catalogue.domain.CharacterCatalog
import com.example.catalogue.navigation.Navigator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

// Un ViewModel par personnage affiché : l'identifiant est son paramètre,
// il ne vient pas de l'entrée de navigation.
class CharacterDetailViewModel(
    id: Int,
    catalog: CharacterCatalog,
    private val navigator: Navigator,
) : ViewModel() {
    private val _uiState =
        MutableStateFlow(CharacterDetailUiState(catalog.byId(id)))
    val uiState: StateFlow<CharacterDetailUiState> =
        _uiState.asStateFlow()

    fun onAction(action: CharacterDetailUiAction) {
        when (action) {
            CharacterDetailUiAction.OnBackClicked -> navigator.back()
        }
    }
}
