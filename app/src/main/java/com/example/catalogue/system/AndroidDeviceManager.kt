package com.example.catalogue.system

import android.content.Context
import android.util.Log

// Le Manager garde le Context de l'Application, jamais celui d'une
// Activity : une Activity détruite à la rotation resterait en mémoire
// tant que le Manager, lui, vit aussi longtemps que l'app.
class AndroidDeviceManager(
    private val appContext: Context,
) : DeviceManager {

    override fun isReady(): Boolean {
        Log.d(TAG, "ready for ${appContext.packageName}")
        return true
    }

    private companion object {
        const val TAG = "DeviceManager"
    }
}
