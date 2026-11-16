package com.example.catalogue.system

import android.content.Context
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.SoundPool
import android.util.Log
import androidx.core.content.ContextCompat
import com.example.catalogue.R

// SoundPool convient aux sons très courts : ils sont décodés une fois,
// puis rejoués sans attente. Context de l'Application, comme DeviceManager.
class SoundPoolSoundManager(
    private val appContext: Context,
) : SoundManager {
    private var pool: SoundPool? = null
    private var soundId = 0

    // Écrit par le callback de chargement, lu au clic.
    @Volatile
    private var loaded = false

    override fun load() {
        // Un seul lecteur à la fois : un deuxième load() ne recrée rien.
        if (pool != null) return
        val newPool = createPool()
        soundId = newPool.load(appContext, R.raw.click, 1)
        pool = newPool
    }

    override fun play() {
        if (!loaded || isSilent()) return
        pool?.play(soundId, 1f, 1f, 1, 0, 1f)
        Log.d(TAG, "play")
    }

    override fun release() {
        pool?.release()
        pool = null
        loaded = false
        Log.d(TAG, "released")
    }

    private fun createPool(): SoundPool {
        val attributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .build()
        return SoundPool.Builder()
            .setMaxStreams(1)
            .setAudioAttributes(attributes)
            .build()
            .also { built ->
                built.setOnLoadCompleteListener { _, _, status ->
                    loaded = status == 0
                    Log.d(TAG, "loaded, status=$status")
                }
            }
    }

    // Pas de clic sonore quand le téléphone est en silencieux ou en vibreur.
    private fun isSilent(): Boolean {
        val audio = ContextCompat.getSystemService(
            appContext,
            AudioManager::class.java,
        )
        return audio?.ringerMode != AudioManager.RINGER_MODE_NORMAL
    }

    private companion object {
        const val TAG = "SoundManager"
    }
}
