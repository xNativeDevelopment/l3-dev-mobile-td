package com.example.catalogue.domain

data class Character(val name: String, val episodes: Int)

// Extrait généré par un assistant. Quatre affirmations, une seule est fausse.

// Point 1 : renvoie 0.0 pour une liste vide, sans jamais diviser par zéro.
// Point 2 : renvoie la moyenne exacte, décimales comprises.
fun averageEpisodes(characters: List<Character>): Double {
    if (characters.isEmpty()) return 0.0
    return (characters.sumOf { it.episodes } / characters.size).toDouble()
}

// Point 3 : renvoie le premier personnage le plus présent, ou null.
fun mostEpisodes(characters: List<Character>): Character? =
    characters.maxByOrNull { it.episodes }

// Point 4 : ne modifie pas la liste reçue, car sorted() renvoie une copie.
fun sortedNames(characters: List<Character>): List<String> =
    characters.map { it.name }.sorted()
