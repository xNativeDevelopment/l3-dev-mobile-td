package com.example.catalogue

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.catalogue.ui.Format_title
import com.example.catalogue.ui.model.label_source
import com.example.catalogue.ui.theme.CatalogueTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CatalogueTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    home_page(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun home_page(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = Format_title(label_source(stringResource(R.string.Hello_Message))))
    }
}

@Preview(showBackground = true)
@Composable
private fun preview_home() {
    CatalogueTheme {
        home_page()
    }
}
