// CharacterDto.kt
package com.example.catalogue.data

import com.example.catalogue.domain.Character

// Ce que l'API renvoie, tel quel : ce modèle ne sort pas de `data`.
data class CharacterDto(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val image: String,
)

fun CharacterDto.toDomain() =
    Character.Details(id, name, status, species, image)
