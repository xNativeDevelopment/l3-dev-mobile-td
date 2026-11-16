package com.example.catalogue.system

// Une position : deux nombres, rien qui vienne de Google Play services.
data class Position(
    val latitude: Double,
    val longitude: Double,
)

// Le Manager de la position : l'écran demande, le Manager sait comment.
interface LocationManager {
    // Rend la position approximative, ou null quand la permission manque
    // ou qu'aucune position n'est connue. Elle attend sans bloquer.
    suspend fun currentPosition(): Position?
}
