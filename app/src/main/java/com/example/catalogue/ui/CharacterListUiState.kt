package com.example.catalogue.ui

import androidx.annotation.StringRes

// Tout ce que l'écran de liste affiche, en un seul objet immuable.
// Pour changer l'écran, on remplace cet objet : on ne le modifie jamais.
data class CharacterListUiState(
    val characters: List<CharacterUiState> = emptyList(),
    val filter: String = "",
    val isLoading: Boolean = false,
    @StringRes val errorMessage: Int? = null,
) {
    // Dérivée de l'état : le ViewModel ne la stocke pas.
    val visibleCharacters: List<CharacterUiState>
        get() = characters.filter {
            it.name.contains(filter, ignoreCase = true)
        }
}
