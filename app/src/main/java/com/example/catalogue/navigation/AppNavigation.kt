package com.example.catalogue.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.example.catalogue.domain.CharacterCatalog
import com.example.catalogue.ui.CharacterDetailScreen
import com.example.catalogue.ui.CharacterListScreen

// Seul endroit qui lit la back stack, pour l'afficher.
@Composable
fun AppNavigation(
    navigator: BackStackNavigator,
    catalog: CharacterCatalog,
    onShare: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    NavDisplay(
        backStack = navigator.backStack,
        modifier = modifier,
        onBack = navigator::back,
        entryProvider = entryProvider {
            entry<ListKey> {
                CharacterListScreen(
                    onShare = { onShare(it.name) },
                )
            }
            entry<DetailKey> { key ->
                CharacterDetailScreen(
                    character = catalog.byId(key.id),
                    navigator = navigator,
                )
            }
        },
    )
}
