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
    // Navigation : back stack, affichage de l'écran du sommet, clés sérialisables
    implementation(libs.androidx.navigation3.runtime)
    implementation(libs.androidx.navigation3.ui)
    implementation(libs.kotlinx.serialization.json)
    // Aperçus, seulement pour le développement
    implementation(libs.androidx.compose.ui.tooling.preview)
    debugImplementation(libs.androidx.compose.ui.tooling)
}
