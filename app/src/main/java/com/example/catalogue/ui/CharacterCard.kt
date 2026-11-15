package com.example.catalogue.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.catalogue.domain.Character
import com.example.catalogue.ui.theme.CatalogueTheme

// La Card n'assemble plus que ses briques : données et lambdas, rien d'autre.
@Composable
fun CharacterCard(
    character: Character,
    modifier: Modifier = Modifier,
    onShare: () -> Unit = {},
) {
    Card(modifier.fillMaxWidth()) {
        Row(
            Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            CharacterAvatar(character.name)
            CharacterInfo(
                character.name,
                character.species,
                character.status,
                Modifier.weight(1f).padding(start = 16.dp),
            )
            TextButton(onClick = onShare) {
                Text("Partager")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CharacterCardPreview() {
    CatalogueTheme {
        CharacterCard(Character(1, "Rick Sanchez", "Alive", "Human"))
    }
}
