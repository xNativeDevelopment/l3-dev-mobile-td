// CharacterService.kt
package com.example.catalogue.data

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.statement.bodyAsText

// Le seul fichier qui sait qu'il y a un réseau : une fonction par endpoint.
// Pour l'instant, il rend la réponse brute, telle que l'API l'envoie.
class CharacterService(private val client: HttpClient) {
    suspend fun fetchPage(page: Int): String =
        client.get("$BASE_URL/character") {
            parameter("page", page)
        }.bodyAsText()

    suspend fun fetchCharacter(id: Int): String =
        client.get("$BASE_URL/character/$id").bodyAsText()

    private companion object {
        const val BASE_URL = "https://rickandmortyapi.com/api"
    }
}
