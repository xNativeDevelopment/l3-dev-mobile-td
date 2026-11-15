package com.example.catalogue.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.catalogue.domain.Character
import com.example.catalogue.ui.theme.CatalogueTheme

@Composable
fun CharacterCard(
    character: Character,
    modifier: Modifier = Modifier,
    onShare: () -> Unit = {},
) {
    // TODO TD 18 : tout tient dans cette seule fonction. Trois briques s'y cachent.
    Card(modifier.fillMaxWidth()) {
        Row(
            Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                Modifier
                    .size(48.dp)
                    .background(MaterialTheme.colorScheme.primaryContainer, CircleShape),
                contentAlignment = Alignment.Center,
            ) {
                Text(character.name.take(1))
            }
            Column(Modifier.weight(1f).padding(start = 16.dp)) {
                Text(character.name)
                Text(character.species)
                Surface(
                    color = if (character.status == "Alive") {
                        MaterialTheme.colorScheme.primary
                    } else {
                        MaterialTheme.colorScheme.error
                    },
                    shape = RoundedCornerShape(50),
                ) {
                    Text(
                        character.status,
                        Modifier.padding(horizontal = 8.dp, vertical = 2.dp),
                        color = Color.White,
                    )
                }
            }
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
