package com.example.catalogue.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.catalogue.ui.theme.CatalogueTheme

// Brique 2 : le badge de statut, vert si le personnage est vivant.
@Composable
fun StatusBadge(status: String, modifier: Modifier = Modifier) {
    Surface(
        modifier,
        color = if (status == "Alive") {
            MaterialTheme.colorScheme.primary
        } else {
            MaterialTheme.colorScheme.error
        },
        shape = RoundedCornerShape(50),
    ) {
        Text(
            status,
            Modifier.padding(horizontal = 8.dp, vertical = 2.dp),
            color = Color.White,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun StatusBadgePreview() {
    CatalogueTheme {
        StatusBadge("Alive")
    }
}
