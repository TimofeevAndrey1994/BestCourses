package com.example.bestcourses.ui.utils

import java.text.SimpleDateFormat
import java.util.Locale


fun formatDate(dateString: String): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val outputFormat = SimpleDateFormat("d MMMM yyyy", Locale("ru")) // "ru" для русского языка

    val date = inputFormat.parse(dateString)
    return outputFormat.format(date ?: "")
}
