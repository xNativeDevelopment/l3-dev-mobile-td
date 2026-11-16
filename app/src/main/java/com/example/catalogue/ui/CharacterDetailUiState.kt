package com.example.catalogue.ui

// Pendant la lecture, isLoading est vrai. Ensuite le personnage est null
// quand l'identifiant n'existe pas ; networkError porte le message
// quand le réseau manque, distinct de « introuvable ».
data class CharacterDetailUiState(
    val character: CharacterUiState? = null,
    val isLoading: Boolean = false,
    val networkError: String? = null,
)
