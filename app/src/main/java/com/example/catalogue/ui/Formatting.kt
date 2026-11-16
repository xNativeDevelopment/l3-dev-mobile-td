package com.example.catalogue.ui

import com.example.catalogue.ui.model.LabelSource

fun formatTitle(source: LabelSource): String {
    val trimmed = source.rawText.trim()
    return trimmed.replaceFirstChar { it.uppercase() }
}
