package com.example.catalogue.system

import android.content.Context
import android.content.Intent

// Intent implicite : on décrit l'action, Android choisit l'application.
fun shareText(context: Context, text: String) {
    val send = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_TEXT, text)
    }
    context.startActivity(Intent.createChooser(send, null))
}
