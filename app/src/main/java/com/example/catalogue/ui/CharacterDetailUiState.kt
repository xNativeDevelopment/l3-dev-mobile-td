package com.example.catalogue.ui

import com.example.catalogue.domain.Character

// Le personnage est null quand l'identifiant n'existe pas dans le catalogue.
data class CharacterDetailUiState(
    val character: Character? = null,
)
