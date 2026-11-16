package com.example.catalogue.ui

// Le seul geste du détail : revenir à l'écran précédent.
sealed interface CharacterDetailUiAction {
    data object OnBackClicked : CharacterDetailUiAction
}
