// CharacterService.kt
package com.example.catalogue.data

// Le contrat du réseau : le repository ne connaît que lui.
// Le vrai service et le mock le remplissent, au choix du module Koin.
interface CharacterService {
    suspend fun fetchPage(page: Int): CharactersPageDto
    suspend fun fetchCharacter(id: Int): CharacterDto?
}
