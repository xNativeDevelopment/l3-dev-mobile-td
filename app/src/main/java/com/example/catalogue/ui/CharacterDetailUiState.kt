package com.example.catalogue.ui

// Pendant la lecture, isLoading est vrai. Ensuite le personnage est null
// quand l'identifiant n'existe pas.
data class CharacterDetailUiState(
    val character: CharacterUiState? = null,
    val isLoading: Boolean = false,
)
