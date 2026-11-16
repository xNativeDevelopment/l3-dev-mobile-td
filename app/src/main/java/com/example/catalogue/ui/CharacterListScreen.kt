// CharacterListScreen.kt
package com.example.catalogue.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.catalogue.domain.Character
import com.example.catalogue.ui.theme.CatalogueTheme
import org.koin.compose.viewmodel.koinViewModel

// La Screen est la seule fonction publique : elle obtient son ViewModel,
// observe son état et lui renvoie les actions. Elle ne connaît plus
// le Navigator : c'est le ViewModel qui décide où aller.
@Composable
fun CharacterListScreen(
    onShare: (Character) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: CharacterListViewModel = koinViewModel(),
) {
    val uiState by viewModel.uiState
        .collectAsStateWithLifecycle()
    CharacterListContent(
        uiState = uiState,
        onAction = viewModel::onAction,
        onShare = onShare,
        modifier = modifier,
    )
}

// Le Content ne fait qu'afficher l'état reçu et remonter des actions.
@Composable
private fun CharacterListContent(
    uiState: CharacterListUiState,
    onAction: (CharacterListUiAction) -> Unit,
    onShare: (Character) -> Unit,
    modifier: Modifier = Modifier,
) {
    val snackbarHostState = remember { SnackbarHostState() }
    // L'événement est consommé : une fois montré, l'écran le retire de
    // l'état, et une rotation ne le rejoue plus.
    LaunchedEffect(uiState.errorMessage) {
        uiState.errorMessage?.let {
            snackbarHostState.showSnackbar(it)
            onAction(CharacterListUiAction.OnErrorShown)
        }
    }
    Box(modifier) {
        Column(Modifier.padding(16.dp)) {
            OutlinedTextField(
                value = uiState.filter,
                onValueChange = { onAction(CharacterListUiAction.OnFilterChanged(it)) },
                label = { Text("Filtrer par nom") },
                modifier = Modifier.fillMaxWidth(),
            )
            Button(onClick = { onAction(CharacterListUiAction.OnReloadClicked) }) {
                Text("Recharger")
            }
            if (uiState.isLoading) {
                CircularProgressIndicator()
            }
            // LazyColumn ne compose que les cartes visibles ; la clé garde
            // l'identité d'une carte quand le filtre change sa position.
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                items(
                    items = uiState.visibleCharacters,
                    key = { it.id },
                ) { character ->
                    CharacterCard(
                        character,
                        Modifier.clickable {
                            onAction(CharacterListUiAction.OnCharacterClicked(character.id))
                        },
                        onShare = { onShare(character) },
                    )
                }
            }
        }
        SnackbarHost(
            snackbarHostState,
            Modifier.align(Alignment.BottomCenter),
        )
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
            onAction = {},
            onShare = {},
        )
    }
}
