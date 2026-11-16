package com.example.catalogue.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.catalogue.domain.Character
import com.example.catalogue.navigation.Navigator
import com.example.catalogue.ui.theme.CatalogueTheme

// La Screen est la seule fonction publique : c'est elle qu'on branchera
// plus tard à un ViewModel. Elle dit où aller au Navigator, sans savoir
// comment on y va.
@Composable
fun CharacterListScreen(
    characters: List<Character>,
    navigator: Navigator,
    onShare: (Character) -> Unit,
    modifier: Modifier = Modifier,
) {
    CharacterListContent(
        characters = characters,
        onOpenDetail = navigator::goToDetail,
        onShare = onShare,
        modifier = modifier,
    )
}

// Le Content ne fait qu'afficher ce qu'il reçoit : aucune logique métier.
@Composable
private fun CharacterListContent(
    characters: List<Character>,
    onOpenDetail: (Int) -> Unit,
    onShare: (Character) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier.padding(16.dp)) {
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
            onOpenDetail = {},
            onShare = {},
        )
    }
}
