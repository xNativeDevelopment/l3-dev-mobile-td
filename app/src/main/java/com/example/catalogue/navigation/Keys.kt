package com.example.catalogue.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

// Une clé par écran. La back stack vit dans BackStackNavigator (single Koin),
// sans sauvegarde : elle survit à la rotation, pas au processus tué.
@Serializable
data object ListKey : NavKey

// Seul l'identifiant voyage dans la clé : le détail recharge le reste.
@Serializable
data class DetailKey(val id: Int) : NavKey

// L'écran À propos n'a pas d'argument : un objet suffit, comme pour la liste.
@Serializable
data object AboutKey : NavKey
