// CharacterListViewModel.kt
package com.example.catalogue.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.catalogue.R
import com.example.catalogue.domain.CharacterRepository
import com.example.catalogue.navigation.Navigator
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.io.IOException

// Le ViewModel écrit l'état ; l'écran ne peut que le lire.
// Il reçoit le Navigator par son constructeur : l'écran n'y touche plus.
class CharacterListViewModel(
    private val repository: CharacterRepository,
    private val navigator: Navigator,
) : ViewModel() {
    private val _uiState =
        MutableStateFlow(CharacterListUiState())
    val uiState: StateFlow<CharacterListUiState> =
        _uiState.asStateFlow()

    init {
        load()
    }

    // Point d'entrée unique : chaque geste arrive ici sous forme d'action.
    fun onAction(action: CharacterListUiAction) {
        when (action) {
            is CharacterListUiAction.OnFilterChanged ->
                _uiState.update { it.copy(filter = action.text) }
            is CharacterListUiAction.OnCharacterClicked ->
                navigator.goToDetail(action.id)
            CharacterListUiAction.OnReloadClicked -> reload()
            CharacterListUiAction.OnErrorShown ->
                _uiState.update { it.copy(errorMessage = null) }
        }
    }

    // Échec simulé : le rechargement échoue toujours après une seconde.
    private fun reload() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            delay(1_000)
            _uiState.update {
                it.copy(
                    isLoading = false,
                    errorMessage = R.string.error_reload_failed,
                )
            }
        }
    }

    private fun load() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            // La fonction suspend attend sans bloquer : l'attente du réseau
            // est dans le repository. Le ViewModel convertit en UiState.
            try {
                val characters =
                    repository.getCharacters().map { it.toUiState() }
                // On remplace l'état avec copy : le flux voit un nouvel objet.
                _uiState.update {
                    it.copy(characters = characters, isLoading = false)
                }
            } catch (e: IOException) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = R.string.error_network,
                    )
                }
            }
        }
    }
}
