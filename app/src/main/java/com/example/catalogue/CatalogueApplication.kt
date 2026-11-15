package com.example.catalogue

import android.app.Application
import com.example.catalogue.data.FakeCharacterProvider
import com.example.catalogue.domain.CharacterProvider

// 1. Le Manifest nomme cette classe : Android la crée d'abord.
class CatalogueApplication : Application() {
    val provider: CharacterProvider = FakeCharacterProvider()

    override fun onCreate() {
        super.onCreate()
        // 2. Initialisation globale : Koin ici (TD 13).
    }
}
