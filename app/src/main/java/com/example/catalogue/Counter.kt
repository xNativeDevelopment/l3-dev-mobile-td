package com.example.catalogue

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun Counter(modifier: Modifier = Modifier) {
    // La rotation recrée l'Activity : remember repart de zéro, rememberSaveable
    // range la valeur dans l'état sauvegardé et la restitue.
    var count by rememberSaveable { mutableStateOf(0) }
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "Compteur : $count")
        Button(onClick = { count++ }) {
            Text(text = "Ajouter 1")
        }
    }
}
