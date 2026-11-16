package com.example.catalogue.navigation

import androidx.compose.runtime.mutableStateListOf
import androidx.navigation3.runtime.NavKey

/**
 * Le seul objet qui possède la back stack.
 *
 * Koin le fournit en `single` : il vit autant que l'app. Seul
 * [AppNavigation] lit [backStack] pour l'afficher ; les écrans
 * passent par l'interface [Navigator] et ne la voient jamais.
 */
class BackStackNavigator : Navigator {
    val backStack = mutableStateListOf<NavKey>(ListKey)

    override fun goToDetail(id: Int) {
        backStack.add(DetailKey(id))
    }

    override fun back() {
        // La liste reste toujours en bas : on ne vide jamais la pile.
        if (backStack.size > 1) backStack.removeAt(backStack.lastIndex)
    }
}
