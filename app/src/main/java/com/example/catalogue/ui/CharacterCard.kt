package com.example.catalogue.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.catalogue.R
import com.example.catalogue.ui.designsystem.AppButton
import com.example.catalogue.ui.designsystem.AppButtonStyle
import com.example.catalogue.ui.designsystem.AppCard
import com.example.catalogue.ui.theme.CatalogueTheme

// La Card n'assemble plus que ses briques : données et lambdas, rien d'autre.
@Composable
fun CharacterCard(
    character: CharacterUiState,
    modifier: Modifier = Modifier,
    onShare: () -> Unit = {},
) {
    AppCard(modifier.fillMaxWidth()) {
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
            AppButton(
                text = stringResource(R.string.card_share),
                onClick = onShare,
                style = AppButtonStyle.Text,
            )
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
