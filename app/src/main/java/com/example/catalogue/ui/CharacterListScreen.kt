// CharacterListScreen.kt
package com.example.catalogue.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.catalogue.domain.Character
import com.example.catalogue.navigation.Navigator
import com.example.catalogue.ui.theme.CatalogueTheme
import org.koin.compose.viewmodel.koinViewModel

// La Screen est la seule fonction publique : elle obtient son ViewModel
// et observe son état. Elle dit où aller au Navigator, sans savoir
// comment on y va.
@Composable
fun CharacterListScreen(
    navigator: Navigator,
    onShare: (Character) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: CharacterListViewModel = koinViewModel(),
) {
    val uiState by viewModel.uiState
        .collectAsStateWithLifecycle()
    CharacterListContent(
        uiState = uiState,
        onOpenDetail = navigator::goToDetail,
        onShare = onShare,
        modifier = modifier,
    )
}

// Le Content ne fait qu'afficher l'état reçu : aucune logique métier.
@Composable
private fun CharacterListContent(
    uiState: CharacterListUiState,
    onOpenDetail: (Int) -> Unit,
    onShare: (Character) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier.padding(16.dp)) {
        if (uiState.isLoading) {
            CircularProgressIndicator()
        }
        uiState.characters.forEach { character ->
            CharacterCard(
                character,
                Modifier.clickable { onOpenDetail(character.id) },
                onShare = { onShare(character) },
            )
        }
    }
}

// L'aperçu vit avec un état fictif : pas besoin de lancer l'app.
@Preview(showBackground = true)
@Composable
private fun CharacterListPreview() {
    CatalogueTheme {
        CharacterListContent(
            uiState = CharacterListUiState(
                characters = listOf(
                    Character(1, "Rick Sanchez", "Alive", "Human"),
                    Character(2, "Morty Smith", "Alive", "Human"),
                ),
            ),
            onOpenDetail = {},
            onShare = {},
        )
    }
}
