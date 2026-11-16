package com.example.catalogue.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import com.example.catalogue.domain.Character
import com.example.catalogue.navigation.DetailKey
import com.example.catalogue.ui.theme.CatalogueTheme

// La Screen est la seule fonction publique : c'est elle qu'on branchera
// plus tard à un ViewModel. Elle reçoit ici la back stack, version simple
// que le TD 22 remplacera par un Navigator.
@Composable
fun CharacterListScreen(
    characters: List<Character>,
    backStack: NavBackStack<NavKey>,
    onShare: (Character) -> Unit,
    modifier: Modifier = Modifier,
) {
    CharacterListContent(
        characters = characters,
        onOpenDetail = { backStack.add(DetailKey) },
        onShare = onShare,
        modifier = modifier,
    )
}

// Le Content ne fait qu'afficher ce qu'il reçoit : aucune logique métier.
@Composable
private fun CharacterListContent(
    characters: List<Character>,
    onOpenDetail: () -> Unit,
    onShare: (Character) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier.padding(16.dp)) {
        Button(onClick = onOpenDetail) {
            Text("Ouvrir le détail")
        }
        characters.forEach { character ->
            CharacterCard(
                character,
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
