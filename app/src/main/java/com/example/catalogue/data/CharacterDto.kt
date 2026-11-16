// CharacterDto.kt
package com.example.catalogue.data

import com.example.catalogue.domain.Character
import kotlinx.serialization.Serializable

// Ce que l'API renvoie : ces modèles ne sortent pas de `data`.
// Les autres champs du JSON sont ignorés au décodage.
@Serializable
data class CharacterDto(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val image: String,
)

// La liste arrive dans une enveloppe : `info` pour paginer, `results`.
@Serializable
data class CharactersPageDto(
    val info: PageInfoDto,
    val results: List<CharacterDto>,
)

// `next` et `prev` valent null aux extrémités : le type l'accepte.
@Serializable
data class PageInfoDto(
    val count: Int,
    val pages: Int,
    val next: String? = null,
    val prev: String? = null,
)

fun CharacterDto.toDomain() =
    Character.Details(id, name, status, species, image)
