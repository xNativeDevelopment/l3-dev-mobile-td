// CharacterListViewModel.kt
package com.example.catalogue.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.catalogue.R
import com.example.catalogue.domain.CharacterRepository
import com.example.catalogue.navigation.Navigator
import com.example.catalogue.system.DeviceManager
import com.example.catalogue.system.SoundManager
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.io.IOException

// Le ViewModel écrit l'état ; l'écran ne peut que le lire.
// Il reçoit le Navigator par son constructeur : l'écran n'y touche plus.
// Le DeviceManager arrive de la même façon : c'est lui qui parle au matériel.
class CharacterListViewModel(
    private val repository: CharacterRepository,
    private val navigator: Navigator,
    private val deviceManager: DeviceManager,
    private val soundManager: SoundManager,
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
            is CharacterListUiAction.OnCharacterClicked -> {
                soundManager.play()
                navigator.goToDetail(action.id)
            }
            // Le chargement et la libération suivent la vie de l'écran :
            // c'est l'écran qui le dit, le Manager ne connaît pas Compose.
            CharacterListUiAction.OnStarted -> soundManager.load()
            CharacterListUiAction.OnStopped -> soundManager.release()
            CharacterListUiAction.OnReloadClicked -> reload()
            CharacterListUiAction.OnErrorShown ->
                _uiState.update { it.copy(errorMessage = null) }
            CharacterListUiAction.OnManagerClicked -> checkManager()
            is CharacterListUiAction.OnPermissionAnswered ->
                _uiState.update {
                    it.copy(permissionMessage = permissionMessage(action))
                }
        }
    }

    // Trois réponses, trois messages : accordée, refusée (on peut
    // redemander) et refusée pour de bon (il reste les réglages).
    private fun permissionMessage(
        answer: CharacterListUiAction.OnPermissionAnswered,
    ): Int = when {
        answer.granted -> R.string.permission_granted
        answer.canAskAgain -> R.string.permission_denied
        else -> R.string.permission_denied_for_good
    }

    // L'écran ne sait pas comment le matériel répond : il lit le message.
    private fun checkManager() {
        val message = if (deviceManager.isReady()) {
            R.string.manager_ready
        } else {
            R.string.manager_not_ready
        }
        _uiState.update { it.copy(managerMessage = message) }
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
