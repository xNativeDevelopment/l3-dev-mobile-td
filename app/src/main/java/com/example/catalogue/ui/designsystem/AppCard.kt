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

/**
 * Card aux couleurs de la marque : coins et fond du thème.
 *
 * À utiliser à la place de [Card] pour tout bloc encadré : on
 * change l'habillage ici, une seule fois, pas dans chaque écran.
 *
 * @param modifier Fourni par l'appelant, qui règle la taille
 *   (`Modifier.fillMaxWidth()`) : la Card n'impose rien.
 * @param content Contenu en colonne. Il gère son espacement
 *   intérieur : la Card n'ajoute aucune marge.
 * @see AppButton
 * @see androidx.compose.material3.Card
 */
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
