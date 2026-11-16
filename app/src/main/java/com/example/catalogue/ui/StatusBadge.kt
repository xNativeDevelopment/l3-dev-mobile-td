package com.example.catalogue.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.catalogue.R
import com.example.catalogue.ui.theme.CatalogueTheme

// Brique 2 : le badge de statut, vert si le personnage est vivant.
@Composable
fun StatusBadge(status: String, modifier: Modifier = Modifier) {
    val alive = status == "Alive"
    Surface(
        modifier,
        color = if (alive) {
            MaterialTheme.colorScheme.primary
        } else {
            MaterialTheme.colorScheme.error
        },
        shape = RoundedCornerShape(50),
    ) {
        Text(
            status,
            Modifier.padding(
                horizontal = dimensionResource(R.dimen.badge_padding_horizontal),
                vertical = dimensionResource(R.dimen.badge_padding_vertical),
            ),
            color = if (alive) {
                MaterialTheme.colorScheme.onPrimary
            } else {
                MaterialTheme.colorScheme.onError
            },
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
