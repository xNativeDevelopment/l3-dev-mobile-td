// ===== Plugins =====
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
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
    // Aperçus, seulement pour le développement
    implementation(libs.androidx.compose.ui.tooling.preview)
    debugImplementation(libs.androidx.compose.ui.tooling)
}
