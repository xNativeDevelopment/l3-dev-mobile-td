// CharacterRepository.kt
package com.example.catalogue.domain

// Le seul point d'accès aux données : suspend, pour ne jamais bloquer l'écran.
interface CharacterRepository {
    suspend fun getCharacters(): List<Character.Preview>
    suspend fun getCharacter(id: Int): Character.Details?
}
