package com.example.catalogue.ui

// Le seul geste de l'écran À propos : revenir à l'écran précédent.
sealed interface AboutUiAction {
    data object OnBackClicked : AboutUiAction
}
