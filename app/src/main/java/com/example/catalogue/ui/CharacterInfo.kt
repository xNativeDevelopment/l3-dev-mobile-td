package com.example.catalogue.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.catalogue.ui.theme.CatalogueTheme

// Brique 3 : le nom, l'espèce et le statut, empilés.
@Composable
fun CharacterInfo(
    name: String,
    species: String,
    status: String,
    modifier: Modifier = Modifier,
) {
    Column(modifier) {
        Text(name)
        Text(species)
        StatusBadge(status)
    }
}

@Preview(showBackground = true)
@Composable
private fun CharacterInfoPreview() {
    CatalogueTheme {
        CharacterInfo("Rick Sanchez", "Human", "Alive")
    }
}
