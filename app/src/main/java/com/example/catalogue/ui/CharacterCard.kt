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
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.catalogue.R
import com.example.catalogue.ui.theme.CatalogueTheme

// La Card n'assemble plus que ses briques : données et lambdas, rien d'autre.
@Composable
fun CharacterCard(
    character: CharacterUiState,
    modifier: Modifier = Modifier,
    onShare: () -> Unit = {},
) {
    Card(modifier.fillMaxWidth()) {
        Row(
            Modifier.padding(dimensionResource(R.dimen.card_padding)),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            CharacterAvatar(character.name)
            CharacterInfo(
                character.name,
                character.species,
                character.status,
                Modifier.weight(1f).padding(
                    start = dimensionResource(R.dimen.card_content_gap),
                ),
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
        CharacterCard(CharacterUiState(1, "Rick Sanchez", "Alive", "Human"))
    }
}
