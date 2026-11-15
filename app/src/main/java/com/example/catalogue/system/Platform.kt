package com.example.catalogue.system

import android.content.Context
import android.widget.Toast
import com.example.catalogue.R

// Trois services du système : chacun demande un Context.
fun showToast(context: Context, text: String) {
    Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
}

fun countLaunch(context: Context): Int {
    val prefs = context.getSharedPreferences("catalogue", Context.MODE_PRIVATE)
    val launches = prefs.getInt("launches", 0) + 1
    prefs.edit().putInt("launches", launches).apply()
    return launches
}

fun appLabel(context: Context): String = context.getString(R.string.app_name)
