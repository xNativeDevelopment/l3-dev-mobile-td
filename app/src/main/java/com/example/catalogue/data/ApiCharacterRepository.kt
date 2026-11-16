// ApiCharacterRepository.kt
package com.example.catalogue.data

import com.example.catalogue.domain.Character
import com.example.catalogue.domain.CharacterRepository

// Le repository convertit : les DTO s'arrêtent ici, le reste de l'app
// ne voit que des modèles de domaine.
class ApiCharacterRepository(
    // L'interface, jamais KtorCharacterService : le module choisit.
    private val service: CharacterService,
) : CharacterRepository {
    override suspend fun getCharacters(): List<Character.Preview> =
        service.fetchPage(1).results.map { it.toDomain().toPreview() }

    // Le service rend null pour un personnage inconnu.
    override suspend fun getCharacter(id: Int): Character.Details? =
        service.fetchCharacter(id)?.toDomain()
}
