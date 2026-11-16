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

// Le domaine garde ce dont le métier a besoin : l'image reste ici.
fun CharacterDto.toDomain() = Character(id, name, status, species)
