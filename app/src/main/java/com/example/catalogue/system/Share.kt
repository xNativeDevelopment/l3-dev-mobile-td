package com.example.catalogue.system

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import com.example.catalogue.R

// Intent implicite : on décrit l'action, Android choisit l'application.
fun shareText(context: Context, text: String) {
    val send = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_TEXT, text)
    }
    try {
        context.startActivity(Intent.createChooser(send, null))
    } catch (e: ActivityNotFoundException) {
        showToast(context, context.getString(R.string.share_no_app))
    }
}
