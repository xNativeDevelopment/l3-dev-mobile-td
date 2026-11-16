package com.example.catalogue.data

import com.example.catalogue.domain.CharacterProvider

// Données fictives au format de The Rick and Morty API.
class FakeCharacterProvider : CharacterProvider {
    private val fakeDtos = listOf(
        CharacterDto(1, "Rick Sanchez", "Alive", "Human", avatar(1)),
        CharacterDto(2, "Morty Smith", "Alive", "Human", avatar(2)),
        CharacterDto(3, "Summer Smith", "Alive", "Human", avatar(3)),
        CharacterDto(4, "Beth Smith", "Alive", "Human", avatar(4)),
        CharacterDto(5, "Jerry Smith", "Alive", "Human", avatar(5)),
        CharacterDto(6, "Abradolf Lincler", "Unknown", "Human", avatar(6)),
        CharacterDto(7, "Birdperson", "Dead", "Alien", avatar(7)),
        CharacterDto(8, "Squanchy", "Alive", "Alien", avatar(8)),
        CharacterDto(9, "Mr. Meeseeks", "Alive", "Humanoid", avatar(9)),
        CharacterDto(10, "Evil Morty", "Alive", "Human", avatar(10)),
        CharacterDto(11, "Pickle Rick", "Alive", "Human", avatar(11)),
        CharacterDto(12, "Scary Terry", "Alive", "Alien", avatar(12)),
    )

    override fun characters() = fakeDtos.map { it.toDomain() }

    private fun avatar(id: Int) =
        "https://rickandmortyapi.com/api/character/avatar/$id.jpeg"
}
