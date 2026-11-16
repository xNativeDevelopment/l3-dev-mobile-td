package com.example.catalogue.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.catalogue.domain.CharacterRepository
import com.example.catalogue.navigation.Navigator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.io.IOException

// Un ViewModel par personnage affiché : l'identifiant est son paramètre,
// il ne vient pas de l'entrée de navigation.
class CharacterDetailViewModel(
    id: Int,
    repository: CharacterRepository,
    private val navigator: Navigator,
) : ViewModel() {
    private val _uiState =
        MutableStateFlow(CharacterDetailUiState(isLoading = true))
    val uiState: StateFlow<CharacterDetailUiState> =
        _uiState.asStateFlow()

    init {
        // Le repository est suspend : on l'attend sans bloquer le thread principal.
        viewModelScope.launch {
            try {
                val character = repository.getCharacter(id)?.toUiState()
                _uiState.update {
                    it.copy(character = character, isLoading = false)
                }
            } catch (e: IOException) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        networkError = "Réseau indisponible : vérifie la connexion.",
                    )
                }
            }
        }
    }

    fun onAction(action: CharacterDetailUiAction) {
        when (action) {
            CharacterDetailUiAction.OnBackClicked -> navigator.back()
        }
    }
}
