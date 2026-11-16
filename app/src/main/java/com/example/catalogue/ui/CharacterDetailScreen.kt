package com.example.catalogue.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.catalogue.domain.Character
import com.example.catalogue.ui.theme.CatalogueTheme

// Le personnage est null quand l'identifiant de la clé n'existe pas.
@Composable
fun CharacterDetailScreen(
    character: Character?,
    onBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    CharacterDetailContent(character, onBack, modifier)
}

@Composable
private fun CharacterDetailContent(
    character: Character?,
    onBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier.padding(16.dp)) {
        if (character == null) {
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
            character = Character(2, "Morty Smith", "Alive", "Human"),
            onBack = {},
        )
    }
}
