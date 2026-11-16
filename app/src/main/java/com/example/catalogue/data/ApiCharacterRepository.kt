// ApiCharacterRepository.kt
package com.example.catalogue.data

import com.example.catalogue.domain.Character
import com.example.catalogue.domain.CharacterRepository
import io.ktor.client.plugins.ClientRequestException

// Le repository convertit : les DTO s'arrêtent ici, le reste de l'app
// ne voit que des modèles de domaine.
class ApiCharacterRepository(
    private val service: CharacterService,
) : CharacterRepository {
    override suspend fun getCharacters(): List<Character.Preview> =
        service.fetchPage(1).results.map { it.toDomain().toPreview() }

    // Une erreur 4xx (personnage inconnu) devient null, pas un plantage.
    override suspend fun getCharacter(id: Int): Character.Details? =
        try {
            service.fetchCharacter(id).toDomain()
        } catch (e: ClientRequestException) {
            null
        }
}
