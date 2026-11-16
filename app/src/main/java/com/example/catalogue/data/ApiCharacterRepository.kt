// ApiCharacterRepository.kt
package com.example.catalogue.data

import com.example.catalogue.domain.CharacterRepository

// Le texte brut vient du service ; les listes restent en mémoire
// (`by local`) jusqu'à ce qu'on sache décoder le JSON, au TD suivant.
class ApiCharacterRepository(
    private val service: CharacterService,
    local: CharacterRepository,
) : CharacterRepository by local {
    override suspend fun getRawPage(): String = service.fetchPage(1)

    override suspend fun getRawCharacter(id: Int): String =
        service.fetchCharacter(id)
}
