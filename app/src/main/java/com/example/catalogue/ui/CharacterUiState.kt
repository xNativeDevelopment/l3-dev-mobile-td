// CharacterUiState.kt
package com.example.catalogue.ui

import com.example.catalogue.domain.Character

// Ce que l'écran affiche d'un personnage, rien de plus.
data class CharacterUiState(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val imageUrl: String? = null,
)

// Pas de `else` : un cas du domaine oublié ne compile pas.
fun Character.toUiState() = when (this) {
    is Character.Preview ->
        CharacterUiState(id, name, status, species)
    is Character.Details ->
        CharacterUiState(id, name, status, species, image)
}
