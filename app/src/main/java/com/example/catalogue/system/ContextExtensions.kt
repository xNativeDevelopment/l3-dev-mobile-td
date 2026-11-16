package com.example.catalogue.system

import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat

/**
 * Dit si l'app a reçu une permission d'exécution.
 *
 * @param permission le nom complet de la permission.
 * @return vrai si la permission est accordée, faux sinon.
 * @see ContextCompat.checkSelfPermission
 */
fun Context.hasPermission(permission: String): Boolean =
    ContextCompat.checkSelfPermission(this, permission) ==
        PackageManager.PERMISSION_GRANTED
