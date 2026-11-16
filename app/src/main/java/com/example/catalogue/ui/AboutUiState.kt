package com.example.catalogue.ui

import androidx.annotation.StringRes
import com.example.catalogue.R

// Ce que l'écran affiche : l'identifiant de deux textes (@StringRes).
// L'écran les traduit, le ViewModel ne connaît pas la langue.
data class AboutUiState(
    @StringRes val title: Int = R.string.about_title,
    @StringRes val body: Int = R.string.about_body,
)
