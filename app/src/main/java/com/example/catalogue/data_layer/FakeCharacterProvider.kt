package com.example.catalogue.data_layer

import com.example.catalogue.domain.Character
import com.example.catalogue.domain.CharacterProvider

// Données fictives au format de The Rick and Morty API.
class FakeCharacterProvider : CharacterProvider {
    private val fakeCharacters = listOf(
        Character(1, "Rick Sanchez", "Alive", "Human"),
        Character(2, "Morty Smith", "Alive", "Human"),
        Character(3, "Summer Smith", "Alive", "Human"),
        Character(4, "Beth Smith", "Alive", "Human"),
        Character(5, "Jerry Smith", "Alive", "Human"),
    )

    override fun characters() = fakeCharacters
}
