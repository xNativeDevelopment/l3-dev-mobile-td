package com.example.catalogue.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

// Une clé par écran. @Serializable permet de sauvegarder la back stack
// quand l'app est recréée (rotation, processus tué).
@Serializable
data object ListKey : NavKey

// Seul l'identifiant voyage dans la clé : le détail recharge le reste.
@Serializable
data class DetailKey(val id: Int) : NavKey
