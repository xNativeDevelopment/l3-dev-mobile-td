package com.example.catalogue.ui

import com.example.catalogue.ui.model.label_source

fun Format_title(source: label_source): String {
  val trimmed = source.Raw_text.trim()
  return trimmed.replaceFirstChar { it.uppercase() }
}
