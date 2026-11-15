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
import com.example.catalogue.domain.CharacterCatalog
import com.example.catalogue.system.Heartbeat
import com.example.catalogue.system.appLabel
import com.example.catalogue.system.countLaunch
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
                    Column(Modifier.padding(innerPadding)) {
                        CharacterCard(catalog.all().first())
                        // TODO TD 16 : quel Context pour lire le nom de l'app ?
                        Text(appLabel(this@MainActivity))
                        Text("Ouvertures de l'écran : $launches")
                        Button(
                            onClick = {
                                // TODO TD 16 : quel Context pour le toast ?
                                showToast(this@MainActivity, "Bonjour")
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
