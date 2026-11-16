package com.example.catalogue.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.catalogue.R
import com.example.catalogue.ui.designsystem.AppButton
import com.example.catalogue.ui.theme.CatalogueTheme
import org.koin.compose.viewmodel.koinViewModel

// La Screen est la seule fonction publique : elle obtient son ViewModel,
// observe son état et lui renvoie les actions.
@Composable
fun AboutScreen(
    modifier: Modifier = Modifier,
    viewModel: AboutViewModel = koinViewModel(),
) {
    val uiState by viewModel.uiState
        .collectAsStateWithLifecycle()
    AboutContent(
        title = uiState.title,
        body = uiState.body,
        onBack = { viewModel.onAction(AboutUiAction.OnBackClicked) },
        modifier = modifier,
    )
}

@Composable
private fun AboutContent(
    @StringRes title: Int,
    @StringRes body: Int,
    onBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier.padding(dimensionResource(R.dimen.screen_padding))) {
        Text(stringResource(title))
        Text(stringResource(body))
        AppButton(
            text = stringResource(R.string.about_back),
            onClick = onBack,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun AboutPreview() {
    CatalogueTheme {
        AboutContent(
            title = R.string.about_title,
            body = R.string.about_body,
            onBack = {},
        )
    }
}
