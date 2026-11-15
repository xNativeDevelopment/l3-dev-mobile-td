package com.example.catalogue.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.catalogue.ui.theme.CatalogueTheme

// Brique 1 : la pastille ronde avec l'initiale du personnage.
@Composable
fun CharacterAvatar(name: String, modifier: Modifier = Modifier) {
    Box(
        modifier
            .size(48.dp)
            .background(MaterialTheme.colorScheme.primaryContainer, CircleShape),
        contentAlignment = Alignment.Center,
    ) {
        Text(name.take(1))
    }
}

@Preview(showBackground = true)
@Composable
private fun CharacterAvatarPreview() {
    CatalogueTheme {
        CharacterAvatar("Rick Sanchez")
    }
}
