package com.example.catalogue.system

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import androidx.core.content.ContextCompat
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.google.android.gms.tasks.CancellationTokenSource
import kotlin.coroutines.resume
import kotlinx.coroutines.suspendCancellableCoroutine

// Context de l'Application, comme les autres Managers.
class FusedLocationManager(
    private val appContext: Context,
) : LocationManager {
    private val client =
        LocationServices.getFusedLocationProviderClient(appContext)

    // Le lint ne voit pas notre test de permission, fait dans la fonction.
    @SuppressLint("MissingPermission")
    override suspend fun currentPosition(): Position? {
        if (!hasPermission()) return null
        return suspendCancellableCoroutine { continuation ->
            val cancellation = CancellationTokenSource()
            // Approximative : un quartier suffit, la précision GPS coûte
            // de la batterie et une permission de plus.
            client.getCurrentLocation(
                Priority.PRIORITY_BALANCED_POWER_ACCURACY,
                cancellation.token,
            ).addOnSuccessListener { location ->
                continuation.resume(location?.toPosition())
            }.addOnFailureListener {
                continuation.resume(null)
            }
            // Coroutine annulée : on retire la demande de position.
            continuation.invokeOnCancellation {
                cancellation.cancel()
            }
        }
    }

    private fun Location.toPosition() = Position(latitude, longitude)

    private fun hasPermission(): Boolean =
        ContextCompat.checkSelfPermission(
            appContext,
            Manifest.permission.ACCESS_COARSE_LOCATION,
        ) == PackageManager.PERMISSION_GRANTED
}
