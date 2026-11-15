package com.example.catalogue

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.catalogue.ui.CharacterCard
import com.example.catalogue.ui.theme.CatalogueTheme

// 3. Puis MainActivity, la seule Activity, pose l'écran.
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val app = application as CatalogueApplication
        val provider = app.provider
        setContent {
            CatalogueTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CharacterCard(
                        provider.characters().first(),
                        Modifier.padding(innerPadding),
                    )
                }
            }
        }
    }
}
