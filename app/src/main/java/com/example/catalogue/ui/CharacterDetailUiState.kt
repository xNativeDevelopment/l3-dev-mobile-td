package com.example.catalogue.ui

import androidx.annotation.StringRes

// Pendant la lecture, isLoading est vrai. Ensuite le personnage est null
// quand l'identifiant n'existe pas ; networkError porte le message
// quand le réseau manque, distinct de « introuvable ». C'est l'identifiant
// d'un texte (@StringRes) : l'écran le traduit, le ViewModel ne connaît pas la langue.
data class CharacterDetailUiState(
    val character: CharacterUiState? = null,
    val isLoading: Boolean = false,
    @StringRes val networkError: Int? = null,
)
