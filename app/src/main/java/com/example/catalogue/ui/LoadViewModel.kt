package com.example.catalogue.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

// Un ViewModel minimal : il garde l'état du chargement, l'écran l'affiche.
class LoadViewModel : ViewModel() {
    var isLoading by mutableStateOf(false)
        private set
    var isLoaded by mutableStateOf(false)
        private set

    // La coroutine vit dans viewModelScope : elle est annulée toute seule
    // quand le ViewModel disparaît. L'attente simulée (un réseau lent)
    // part sur Dispatchers.IO, le thread principal reste libre.
    fun load() {
        if (isLoading) return
        viewModelScope.launch {
            isLoading = true
            withContext(Dispatchers.IO) { Thread.sleep(2_000) }
            isLoading = false
            isLoaded = true
        }
    }
}
