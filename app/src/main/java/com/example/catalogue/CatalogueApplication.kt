package com.example.catalogue

import android.app.Application
import com.example.catalogue.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

// 1. Le Manifest nomme cette classe : Android la crée d'abord.
class CatalogueApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // 2. Initialisation globale : Koin démarre ici, une fois.
        startKoin {
            androidContext(this@CatalogueApplication)
            modules(appModule)
        }
    }
}
