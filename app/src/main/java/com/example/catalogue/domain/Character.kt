// Character.kt
package com.example.catalogue.domain

// Le métier : ni le JSON de l'API, ni ce que l'écran affiche.
sealed interface Character {
    val id: Int
    val name: String

    // Ce dont la liste a besoin.
    data class Preview(
        override val id: Int,
        override val name: String,
        val status: String,
        val species: String,
    ) : Character

    // Tout ce que le détail montre.
    data class Details(
        override val id: Int,
        override val name: String,
        val status: String,
        val species: String,
        val image: String,
    ) : Character {
        fun toPreview() = Preview(id, name, status, species)
    }
}
