// MockCharacterService.kt
package com.example.catalogue.data

import kotlinx.coroutines.delay

// Données fixes au format de The Rick and Morty API : l'app tourne sans réseau.
class MockCharacterService : CharacterService {
    private val characters = listOf(
        CharacterDto(1, "Rick Sanchez", "Alive", "Human", avatar(1)),
        CharacterDto(2, "Morty Smith", "Alive", "Human", avatar(2)),
        CharacterDto(3, "Summer Smith", "Alive", "Human", avatar(3)),
        CharacterDto(4, "Beth Smith", "Alive", "Human", avatar(4)),
        CharacterDto(5, "Jerry Smith", "Alive", "Human", avatar(5)),
        CharacterDto(6, "Abradolf Lincler", "unknown", "Human", avatar(6)),
        CharacterDto(7, "Birdperson", "Dead", "Alien", avatar(7)),
        CharacterDto(8, "Squanchy", "Alive", "Alien", avatar(8)),
        CharacterDto(9, "Mr. Meeseeks", "Alive", "Humanoid", avatar(9)),
        CharacterDto(10, "Evil Morty", "Alive", "Human", avatar(10)),
        CharacterDto(11, "Pickle Rick", "Alive", "Human", avatar(11)),
        CharacterDto(12, "Scary Terry", "Alive", "Alien", avatar(12)),
    )

    // Une courte attente rend l'écran de chargement visible, comme en vrai.
    override suspend fun fetchPage(
        page: Int,
    ): CharactersPageDto {
        delay(500)
        return CharactersPageDto(PageInfoDto(12, 1), characters)
    }

    override suspend fun fetchCharacter(id: Int): CharacterDto? {
        delay(500)
        return characters.firstOrNull { it.id == id }
    }

    private fun avatar(id: Int) =
        "https://rickandmortyapi.com/api/character/avatar/$id.jpeg"
}
