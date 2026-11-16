package com.example.catalogue.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

// Un ViewModel minimal : il garde l'état du chargement, l'écran l'affiche.
class LoadViewModel : ViewModel() {
    var isLoading by mutableStateOf(false)
        private set
    var isLoaded by mutableStateOf(false)
        private set

    // Appel bloquant simulé (un réseau lent). Lancé tel quel depuis le
    // thread principal, il gèle l'écran pendant 2 secondes.
    fun load() {
        isLoading = true
        Thread.sleep(2_000)
        isLoading = false
        isLoaded = true
    }
}
