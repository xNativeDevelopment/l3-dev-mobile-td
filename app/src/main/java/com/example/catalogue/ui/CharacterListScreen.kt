package com.example.catalogue.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.catalogue.domain.Character
import com.example.catalogue.navigation.Navigator
import com.example.catalogue.ui.theme.CatalogueTheme

// La Screen est la seule fonction publique : c'est elle qui obtient le
// ViewModel. Elle dit où aller au Navigator, sans savoir comment on y va.
@Composable
fun CharacterListScreen(
    characters: List<Character>,
    navigator: Navigator,
    onShare: (Character) -> Unit,
    modifier: Modifier = Modifier,
    loadViewModel: LoadViewModel = viewModel(),
) {
    CharacterListContent(
        characters = characters,
        isLoading = loadViewModel.isLoading,
        isLoaded = loadViewModel.isLoaded,
        onLoad = loadViewModel::load,
        onOpenDetail = navigator::goToDetail,
        onShare = onShare,
        modifier = modifier,
    )
}

// Le Content ne fait qu'afficher ce qu'il reçoit : aucune logique métier.
@Composable
private fun CharacterListContent(
    characters: List<Character>,
    isLoading: Boolean,
    isLoaded: Boolean,
    onLoad: () -> Unit,
    onOpenDetail: (Int) -> Unit,
    onShare: (Character) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier.padding(16.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Button(onClick = onLoad) {
                Text("Charger")
            }
            // Si l'écran est gelé, ce cercle s'arrête de tourner.
            if (isLoading) {
                CircularProgressIndicator(Modifier.padding(start = 16.dp))
            }
            if (isLoaded) {
                Text("Chargé", Modifier.padding(start = 16.dp))
            }
        }
        characters.forEach { character ->
            CharacterCard(
                character,
                Modifier.clickable { onOpenDetail(character.id) },
                onShare = { onShare(character) },
            )
        }
    }
}

// L'aperçu vit avec des données fictives : pas besoin de lancer l'app.
@Preview(showBackground = true)
@Composable
private fun CharacterListPreview() {
    CatalogueTheme {
        CharacterListContent(
            characters = listOf(
                Character(1, "Rick Sanchez", "Alive", "Human"),
                Character(2, "Morty Smith", "Alive", "Human"),
            ),
            isLoading = false,
            isLoaded = false,
            onLoad = {},
            onOpenDetail = {},
            onShare = {},
        )
    }
}
