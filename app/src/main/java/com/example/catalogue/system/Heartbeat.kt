package com.example.catalogue.system

import android.os.Handler
import android.os.Looper
import android.util.Log

// Un battement toutes les secondes dans Logcat (filtre : Heartbeat).
class Heartbeat {
    private val handler = Handler(Looper.getMainLooper())
    private val beat = object : Runnable {
        override fun run() {
            Log.d(TAG, "tick")
            handler.postDelayed(this, 1_000)
        }
    }

    fun start() {
        handler.post(beat)
    }

    fun stop() {
        handler.removeCallbacks(beat)
    }

    private companion object {
        const val TAG = "Heartbeat"
    }
}
