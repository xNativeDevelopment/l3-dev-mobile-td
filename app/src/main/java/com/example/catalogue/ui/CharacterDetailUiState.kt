package com.example.catalogue.ui

// Le personnage est null quand l'identifiant n'existe pas dans le catalogue.
data class CharacterDetailUiState(
    val character: CharacterUiState? = null,
)
