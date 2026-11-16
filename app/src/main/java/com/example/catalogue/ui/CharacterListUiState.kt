package com.example.catalogue.ui

import com.example.catalogue.domain.Character

// Tout ce que l'écran de liste affiche, en un seul objet immuable.
// Pour changer l'écran, on remplace cet objet : on ne le modifie jamais.
data class CharacterListUiState(
    val characters: List<Character> = emptyList(),
    val isLoading: Boolean = false,
)
