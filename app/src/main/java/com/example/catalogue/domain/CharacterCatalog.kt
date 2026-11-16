package com.example.catalogue.domain

class CharacterCatalog(private val provider: CharacterProvider) {
    // La liste n'a besoin que des aperçus.
    fun all(): List<Character.Preview> =
        provider.characters().map { it.toPreview() }

    // Le détail ne reçoit que l'identifiant : il retrouve le personnage ici.
    fun byId(id: Int): Character.Details? =
        provider.characters().firstOrNull { it.id == id }
}
