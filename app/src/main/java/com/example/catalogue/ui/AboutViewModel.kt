package com.example.catalogue.ui

import androidx.lifecycle.ViewModel
import com.example.catalogue.navigation.Navigator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

// Squelette de ViewModel répliqué depuis le détail : un état privé
// qu'il est seul à écrire, une seule entrée pour les actions.
class AboutViewModel(
    private val navigator: Navigator,
) : ViewModel() {
    private val _uiState = MutableStateFlow(AboutUiState())
    val uiState: StateFlow<AboutUiState> = _uiState.asStateFlow()

    fun onAction(action: AboutUiAction) {
        when (action) {
            AboutUiAction.OnBackClicked -> navigator.back()
        }
    }
}
