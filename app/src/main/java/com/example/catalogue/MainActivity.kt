package com.example.catalogue

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.catalogue.domain.CharacterCatalog
import com.example.catalogue.system.Heartbeat
import com.example.catalogue.system.shareText
import com.example.catalogue.ui.CharacterListScreen
import com.example.catalogue.ui.theme.CatalogueTheme
import org.koin.android.ext.android.inject

// MainActivity, la seule Activity, pose l'écran et rien d'autre.
class MainActivity : ComponentActivity() {
    private val catalog: CharacterCatalog by inject()
    // Le battement suit l'Activity visible : démarré à l'affichage,
    // arrêté dès qu'elle quitte l'écran (rotation, retour au lanceur).
    private val heartbeat = Heartbeat()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CatalogueTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val context = LocalContext.current
                    CharacterListScreen(
                        characters = catalog.all(),
                        onShare = { shareText(context, it.name) },
                        modifier = Modifier.padding(innerPadding),
                    )
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        heartbeat.start()
    }

    override fun onStop() {
        heartbeat.stop()
        super.onStop()
    }
}
