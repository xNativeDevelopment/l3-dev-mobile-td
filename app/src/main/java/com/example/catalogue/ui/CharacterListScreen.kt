// CharacterListScreen.kt
package com.example.catalogue.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.catalogue.R
import com.example.catalogue.ui.designsystem.AppButton
import com.example.catalogue.ui.designsystem.AppTextField
import com.example.catalogue.ui.theme.CatalogueTheme
import org.koin.compose.viewmodel.koinViewModel

// La Screen est la seule fonction publique : elle obtient son ViewModel,
// observe son état et lui renvoie les actions. Elle ne connaît plus
// le Navigator : c'est le ViewModel qui décide où aller.
@Composable
fun CharacterListScreen(
    onShare: (CharacterUiState) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: CharacterListViewModel = koinViewModel(),
) {
    val uiState by viewModel.uiState
        .collectAsStateWithLifecycle()
    // Pas onDestroy : il peut ne jamais être appelé.
    // onStop l'est toujours avant que le système tue le processus.
    // Charger à l'affichage et libérer à l'arrêt rend la mémoire audio
    // dès que plus personne ne voit l'écran.
    LifecycleEventEffect(Lifecycle.Event.ON_START) {
        viewModel.onAction(CharacterListUiAction.OnStarted)
    }
    LifecycleEventEffect(Lifecycle.Event.ON_STOP) {
        viewModel.onAction(CharacterListUiAction.OnStopped)
    }
    // Le lanceur vit dans l'écran : il a besoin de l'Activity, pas le ViewModel.
    val requestLocation = rememberLocationRequest { granted, canAskAgain ->
        viewModel.onAction(
            CharacterListUiAction.OnPermissionAnswered(granted, canAskAgain),
        )
    }
    CharacterListContent(
        uiState = uiState,
        onAction = viewModel::onAction,
        onShare = onShare,
        onLocationClick = requestLocation,
        modifier = modifier,
    )
}

// Le Content ne fait qu'afficher l'état reçu et remonter des actions.
@Composable
private fun CharacterListContent(
    uiState: CharacterListUiState,
    onAction: (CharacterListUiAction) -> Unit,
    onShare: (CharacterUiState) -> Unit,
    onLocationClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val snackbarHostState = remember { SnackbarHostState() }
    // L'événement est consommé : une fois montré, l'écran le retire de
    // l'état, et une rotation ne le rejoue plus.
    val errorText = uiState.errorMessage?.let { stringResource(it) }
    LaunchedEffect(uiState.errorMessage) {
        errorText?.let {
            snackbarHostState.showSnackbar(it)
            onAction(CharacterListUiAction.OnErrorShown)
        }
    }
    Box(modifier) {
        Column(Modifier.padding(dimensionResource(R.dimen.screen_padding))) {
            AppTextField(
                value = uiState.filter,
                onValueChange = { onAction(CharacterListUiAction.OnFilterChanged(it)) },
                label = stringResource(R.string.list_filter_label),
                modifier = Modifier.fillMaxWidth(),
            )
            AppButton(
                text = stringResource(R.string.list_reload),
                onClick = { onAction(CharacterListUiAction.OnReloadClicked) },
            )
            AppButton(
                text = stringResource(R.string.list_manager),
                onClick = { onAction(CharacterListUiAction.OnManagerClicked) },
            )
            AppButton(
                text = stringResource(R.string.list_about),
                onClick = { onAction(CharacterListUiAction.OnAboutClicked) },
            )
            uiState.managerMessage?.let { Text(stringResource(it)) }
            // On explique avant de demander : le système, lui, ne dit rien.
            Text(stringResource(R.string.location_why))
            AppButton(
                text = stringResource(R.string.list_location),
                onClick = onLocationClick,
            )
            uiState.permissionMessage?.let { Text(stringResource(it)) }
            AppButton(
                text = stringResource(R.string.list_locate),
                onClick = { onAction(CharacterListUiAction.OnLocateClicked) },
            )
            uiState.position?.let {
                Text(
                    stringResource(
                        R.string.location_position,
                        it.latitude,
                        it.longitude,
                    ),
                )
            }
            uiState.locationMessage?.let { Text(stringResource(it)) }
            if (uiState.isLoading) {
                CircularProgressIndicator()
            }
            // LazyColumn ne compose que les cartes visibles ; la clé garde
            // l'identité d'une carte quand le filtre change sa position.
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.list_item_spacing)),
            ) {
                items(
                    items = uiState.visibleCharacters,
                    key = { it.id },
                ) { character ->
                    CharacterCard(
                        character,
                        Modifier.clickable {
                            onAction(CharacterListUiAction.OnCharacterClicked(character.id))
                        },
                        onShare = { onShare(character) },
                    )
                }
            }
        }
        SnackbarHost(
            snackbarHostState,
            Modifier.align(Alignment.BottomCenter),
        )
    }
}

// L'aperçu vit avec un état fictif : pas besoin de lancer l'app.
@Preview(showBackground = true)
@Composable
private fun CharacterListPreview() {
    CatalogueTheme {
        CharacterListContent(
            uiState = CharacterListUiState(
                characters = listOf(
                    CharacterUiState(1, "Rick Sanchez", "Alive", "Human"),
                    CharacterUiState(2, "Morty Smith", "Alive", "Human"),
                ),
            ),
            onAction = {},
            onShare = {},
            onLocationClick = {},
        )
    }
}
