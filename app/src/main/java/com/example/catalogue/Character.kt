package com.example.catalogue

// Les champs que l'API expose pour un personnage, réduits à ceux du TD.
data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
)
