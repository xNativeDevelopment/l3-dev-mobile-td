// CharacterService.kt
package com.example.catalogue.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

// Le seul fichier qui sait qu'il y a un réseau : une fonction par endpoint.
// Le client décode le JSON : le service rend des DTO, plus du texte.
class CharacterService(private val client: HttpClient) {
    suspend fun fetchPage(page: Int): CharactersPageDto =
        client.get("$BASE_URL/character") {
            parameter("page", page)
        }.body()

    suspend fun fetchCharacter(id: Int): CharacterDto =
        client.get("$BASE_URL/character/$id").body()

    private companion object {
        const val BASE_URL = "https://rickandmortyapi.com/api"
    }
}
