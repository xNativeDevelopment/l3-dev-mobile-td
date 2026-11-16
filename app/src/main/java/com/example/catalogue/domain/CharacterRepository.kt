// CharacterRepository.kt
package com.example.catalogue.domain

// Le seul point d'accès aux données : suspend, pour ne jamais bloquer l'écran.
interface CharacterRepository {
    suspend fun getCharacters(): List<Character.Preview>
    suspend fun getCharacter(id: Int): Character.Details?

    // Étape intermédiaire : le texte JSON de l'API, pas encore décodé.
    suspend fun getRawPage(): String
    suspend fun getRawCharacter(id: Int): String
}
