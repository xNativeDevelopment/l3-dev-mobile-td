package com.example.catalogue.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.catalogue.ui.theme.CatalogueTheme
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf

// La clé contient l'identifiant : deux détails n'ont jamais le même ViewModel.
// Il reste dans le magasin de l'Activity jusqu'à sa fin, la clé ne le libère pas.
@Composable
fun CharacterDetailScreen(
    id: Int,
    modifier: Modifier = Modifier,
    viewModel: CharacterDetailViewModel =
        koinViewModel(key = "detail-$id") { parametersOf(id) },
) {
    val uiState by viewModel.uiState
        .collectAsStateWithLifecycle()
    CharacterDetailContent(
        character = uiState.character,
        isLoading = uiState.isLoading,
        onBack = { viewModel.onAction(CharacterDetailUiAction.OnBackClicked) },
        modifier = modifier,
    )
}

@Composable
private fun CharacterDetailContent(
    character: CharacterUiState?,
    isLoading: Boolean,
    onBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier.padding(16.dp)) {
        if (isLoading) {
            CircularProgressIndicator()
        } else if (character == null) {
            Text("Personnage introuvable")
        } else {
            CharacterInfo(
                character.name,
                character.species,
                character.status,
            )
        }
        Button(onClick = onBack) {
            Text("Retour")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CharacterDetailPreview() {
    CatalogueTheme {
        CharacterDetailContent(
            character = CharacterUiState(2, "Morty Smith", "Alive", "Human"),
            isLoading = false,
            onBack = {},
        )
    }
}
