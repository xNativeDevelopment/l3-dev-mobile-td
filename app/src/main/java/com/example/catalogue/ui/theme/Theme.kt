package com.example.catalogue.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import com.example.catalogue.R

@Composable
fun CatalogueTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colorScheme = if (darkTheme) {
        darkColorScheme(
            primary = colorResource(R.color.brand_primary_dark),
            onPrimary = colorResource(R.color.on_brand_dark),
            primaryContainer = colorResource(R.color.brand_container_dark),
            secondary = colorResource(R.color.brand_secondary_dark),
            tertiary = colorResource(R.color.brand_tertiary_dark),
            error = colorResource(R.color.alert_dark),
            onError = colorResource(R.color.on_brand_dark),
        )
    } else {
        lightColorScheme(
            primary = colorResource(R.color.brand_primary),
            onPrimary = colorResource(R.color.on_brand),
            primaryContainer = colorResource(R.color.brand_container),
            secondary = colorResource(R.color.brand_secondary),
            tertiary = colorResource(R.color.brand_tertiary),
            error = colorResource(R.color.alert),
            onError = colorResource(R.color.on_brand),
        )
    }
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content,
    )
}
