// ===== Plugins =====
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.serialization)
}

// ===== Configuration Android =====
android {
    namespace = "com.example.catalogue"
    compileSdk = 37

    defaultConfig {
        applicationId = "com.example.catalogue"
        minSdk = 26
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        compose = true
    }
}

// ===== Dépendances =====
dependencies {
    // Compose : écran, thème, composants
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.material3)
    // Injection de dépendances
    implementation(libs.koin.android)
    // Obtenir un ViewModel depuis Koin dans un composable
    implementation(libs.koin.compose.viewmodel)
    // Navigation : back stack, affichage de l'écran du sommet, clés sérialisables
    implementation(libs.androidx.navigation3.runtime)
    implementation(libs.androidx.navigation3.ui)
    implementation(libs.kotlinx.serialization.json)
    // ViewModel : l'état de l'écran survit à la rotation
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    // Observer un flux seulement tant que l'écran est visible
    implementation(libs.androidx.lifecycle.runtime.compose)
    // Coroutines : lancer un travail sans bloquer le thread principal
    implementation(libs.kotlinx.coroutines.android)
    // Réseau : le client Ktor et son moteur pour Android
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.android)
    // Aperçus, seulement pour le développement
    implementation(libs.androidx.compose.ui.tooling.preview)
    debugImplementation(libs.androidx.compose.ui.tooling)
}
