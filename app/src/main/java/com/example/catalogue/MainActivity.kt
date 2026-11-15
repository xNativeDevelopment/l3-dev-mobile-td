package com.example.catalogue

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.catalogue.domain.CharacterCatalog
import com.example.catalogue.system.Heartbeat
import com.example.catalogue.system.appLabel
import com.example.catalogue.system.countLaunch
import com.example.catalogue.system.shareText
import com.example.catalogue.system.showToast
import com.example.catalogue.ui.CharacterCard
import com.example.catalogue.ui.theme.CatalogueTheme
import org.koin.android.ext.android.inject

// 3. Puis MainActivity, la seule Activity, pose l'écran.
class MainActivity : ComponentActivity() {
    private val catalog: CharacterCatalog by inject()
    // Le battement suit l'Activity visible : démarré à l'affichage,
    // arrêté dès qu'elle quitte l'écran (rotation, retour au lanceur).
    private val heartbeat = Heartbeat()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Application : aussi durable que le processus, aucune Activity retenue.
        val launches = countLaunch(applicationContext)
        setContent {
            CatalogueTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Activity, via Compose : thème et langue de l'écran affiché.
                    val context = LocalContext.current
                    Column(Modifier.padding(innerPadding)) {
                        val character = catalog.all().first()
                        CharacterCard(
                            character,
                            onShare = { shareText(context, character.name) },
                        )
                        Text(appLabel(context))
                        Text("Ouvertures de l'écran : $launches")
                        Button(
                            onClick = {
                                showToast(context, "Bonjour")
                            },
                        ) {
                            Text("Dire bonjour")
                        }
                    }
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
