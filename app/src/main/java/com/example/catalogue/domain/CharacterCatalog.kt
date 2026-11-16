package com.example.catalogue.domain

class CharacterCatalog(private val provider: CharacterProvider) {
    fun all(): List<Character> = provider.characters()

    // Le détail ne reçoit que l'identifiant : il retrouve le personnage ici.
    fun byId(id: Int): Character? = all().firstOrNull { it.id == id }
}
