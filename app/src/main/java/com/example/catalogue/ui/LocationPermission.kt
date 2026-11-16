package com.example.catalogue.ui

import android.Manifest
import androidx.activity.compose.LocalActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable

// Position approximative seulement : la précision GPS n'est pas demandée.
private const val PERMISSION =
    Manifest.permission.ACCESS_COARSE_LOCATION

// Rend la fonction qui ouvre la boîte de dialogue du système. La réponse
// arrive dans onAnswer : accordée ou non, et si le système accepte encore
// de redemander. Pas de bibliothèque en plus : l'API Activity Result suffit.
@Composable
fun rememberLocationRequest(
    onAnswer: (granted: Boolean, canAskAgain: Boolean) -> Unit,
): () -> Unit {
    val activity = LocalActivity.current
    val launcher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission(),
    ) { granted ->
        // Refusée et plus de rationale : le système n'affichera plus la
        // boîte, seuls les réglages de l'app peuvent encore l'accorder.
        val canAskAgain = activity
            ?.shouldShowRequestPermissionRationale(PERMISSION)
            ?: false
        onAnswer(granted, canAskAgain)
    }
    return { launcher.launch(PERMISSION) }
}
