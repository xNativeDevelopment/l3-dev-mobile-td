// CharacterUiState.kt
package com.example.catalogue.ui

import com.example.catalogue.domain.Character

// Ce que l'écran affiche d'un personnage, rien de plus.
data class CharacterUiState(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
)

fun Character.toUiState() = CharacterUiState(id, name, status, species)
