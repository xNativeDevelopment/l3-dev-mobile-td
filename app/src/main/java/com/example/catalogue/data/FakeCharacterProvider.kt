package com.example.catalogue.data

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
        Character(6, "Abradolf Lincler", "Unknown", "Human"),
        Character(7, "Birdperson", "Dead", "Alien"),
        Character(8, "Squanchy", "Alive", "Alien"),
        Character(9, "Mr. Meeseeks", "Alive", "Humanoid"),
        Character(10, "Evil Morty", "Alive", "Human"),
        Character(11, "Pickle Rick", "Alive", "Human"),
        Character(12, "Scary Terry", "Alive", "Alien"),
    )

    override fun characters() = fakeCharacters
}
