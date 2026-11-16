// CharacterListViewModel.kt
package com.example.catalogue.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.catalogue.domain.CharacterCatalog
import com.example.catalogue.navigation.Navigator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

// Le ViewModel écrit l'état ; l'écran ne peut que le lire.
// Il reçoit le Navigator par son constructeur : l'écran n'y touche plus.
class CharacterListViewModel(
    private val catalog: CharacterCatalog,
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
                    errorMessage = "Rechargement impossible, réessaie plus tard.",
                )
            }
        }
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
