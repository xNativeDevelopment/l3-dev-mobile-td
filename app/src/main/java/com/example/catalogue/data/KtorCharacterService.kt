// KtorCharacterService.kt
package com.example.catalogue.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.request.get
import io.ktor.client.request.parameter

// Le vrai service : il parle à l'API avec Ktor et décode le JSON.
class KtorCharacterService(
    private val client: HttpClient,
) : CharacterService {
    override suspend fun fetchPage(page: Int): CharactersPageDto =
        client.get("$BASE_URL/character") {
            parameter("page", page)
        }.body()

    // Une erreur 4xx (personnage inconnu) devient null, comme le mock.
    override suspend fun fetchCharacter(id: Int): CharacterDto? =
        try {
            client.get("$BASE_URL/character/$id").body()
        } catch (e: ClientRequestException) {
            null
        }

    private companion object {
        const val BASE_URL = "https://rickandmortyapi.com/api"
    }
}
