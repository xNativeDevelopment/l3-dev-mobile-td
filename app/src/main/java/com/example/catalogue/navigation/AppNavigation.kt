package com.example.catalogue.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.catalogue.domain.CharacterCatalog
import com.example.catalogue.ui.CharacterDetailScreen
import com.example.catalogue.ui.CharacterListScreen

// La back stack est une liste de clés : le dernier élément est l'écran visible.
@Composable
fun AppNavigation(
    catalog: CharacterCatalog,
    onShare: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val backStack = rememberNavBackStack(ListKey)
    NavDisplay(
        backStack = backStack,
        modifier = modifier,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<ListKey> {
                CharacterListScreen(
                    characters = catalog.all(),
                    backStack = backStack,
                    onShare = { onShare(it.name) },
                )
            }
            entry<DetailKey> {
                CharacterDetailScreen(
                    onBack = { backStack.removeLastOrNull() },
                )
            }
        },
    )
}
