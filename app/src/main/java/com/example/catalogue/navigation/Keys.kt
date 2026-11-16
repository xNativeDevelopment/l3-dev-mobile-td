package com.example.catalogue.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

// Une clé par écran. @Serializable permet de sauvegarder la back stack
// quand l'app est recréée (rotation, processus tué).
@Serializable
data object ListKey : NavKey

@Serializable
data object DetailKey : NavKey
