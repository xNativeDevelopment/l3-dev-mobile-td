package com.example.catalogue.domain

class CharacterCatalog(private val provider: CharacterProvider) {
    fun all(): List<Character> = provider.characters()
}
