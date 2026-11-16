package com.example.catalogue.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import com.example.catalogue.R

@Composable
fun CatalogueTheme(
    content: @Composable () -> Unit,
) {
    val colorScheme = lightColorScheme(
        primary = colorResource(R.color.brand_primary),
        onPrimary = colorResource(R.color.on_brand),
        primaryContainer = colorResource(R.color.brand_container),
        secondary = colorResource(R.color.brand_secondary),
        tertiary = colorResource(R.color.brand_tertiary),
        error = colorResource(R.color.alert),
        onError = colorResource(R.color.on_brand),
    )
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content,
    )
}
