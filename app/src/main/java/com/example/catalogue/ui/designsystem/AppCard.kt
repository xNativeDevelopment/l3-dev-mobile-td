package com.example.catalogue.ui.designsystem

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.catalogue.R
import com.example.catalogue.ui.theme.CatalogueTheme

// La Card brandée : coins arrondis et fond lus dans le thème et dimens.xml.
@Composable
fun AppCard(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit,
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(dimensionResource(R.dimen.component_corner_radius)),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        content = content,
    )
}

@Preview(showBackground = true)
@Composable
private fun AppCardPreview() {
    CatalogueTheme {
        AppCard {
            Text(
                stringResource(R.string.app_name),
                Modifier.padding(dimensionResource(R.dimen.card_padding)),
            )
        }
    }
}
