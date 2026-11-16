package com.example.catalogue.ui

// Les gestes de l'utilisateur, un par intention. L'état descend vers
// l'écran, ces actions remontent vers le ViewModel.
sealed interface CharacterListUiAction {
    data class OnFilterChanged(
        val text: String,
    ) : CharacterListUiAction

    data class OnCharacterClicked(
        val id: Int,
    ) : CharacterListUiAction

    data object OnReloadClicked : CharacterListUiAction

    data object OnManagerClicked : CharacterListUiAction

    // L'écran devient visible, puis il ne l'est plus : le son suit.
    data object OnStarted : CharacterListUiAction

    data object OnStopped : CharacterListUiAction

    // La réponse du système à la demande de position.
    data class OnPermissionAnswered(
        val granted: Boolean,
        val canAskAgain: Boolean,
    ) : CharacterListUiAction

    // L'écran a montré le message : il peut sortir de l'état.
    data object OnErrorShown : CharacterListUiAction
}
