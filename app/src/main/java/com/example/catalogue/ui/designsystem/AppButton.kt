package com.example.catalogue.ui.designsystem

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.catalogue.R
import com.example.catalogue.ui.theme.CatalogueTheme

// Les deux styles de bouton de l'app : un seul endroit pour les définir.
enum class AppButtonStyle { Filled, Text }

// Le bouton de l'app : forme et couleurs viennent du thème, pas de l'écran.
@Composable
fun AppButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    style: AppButtonStyle = AppButtonStyle.Filled,
) {
    val shape = RoundedCornerShape(dimensionResource(R.dimen.button_corner_radius))
    when (style) {
        AppButtonStyle.Filled -> Button(
            onClick = onClick,
            modifier = modifier,
            shape = shape,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary,
            ),
        ) {
            Text(text)
        }
        AppButtonStyle.Text -> TextButton(
            onClick = onClick,
            modifier = modifier,
            shape = shape,
        ) {
            Text(text)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AppButtonPreview() {
    CatalogueTheme {
        AppButton(stringResource(R.string.list_reload), onClick = {})
    }
}

@Preview(showBackground = true)
@Composable
private fun AppButtonTextStylePreview() {
    CatalogueTheme {
        AppButton(
            stringResource(R.string.card_share),
            onClick = {},
            style = AppButtonStyle.Text,
        )
    }
}
