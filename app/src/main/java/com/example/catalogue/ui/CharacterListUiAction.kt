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

    // L'écran a montré le message : il peut sortir de l'état.
    data object OnErrorShown : CharacterListUiAction
}
