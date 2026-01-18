package com.example.answerit.data

import com.example.answerit.data.BackgroundTheme
import com.example.answerit.data.Language

// Add other fields as needed for your app

data class AppSettings(
    val backgroundTheme: BackgroundTheme = BackgroundTheme.MINIMAL_DARK,
    val language: Language = Language.ENGLISH,
    val soundEnabled: Boolean = true,
    val vibrationEnabled: Boolean = true
) 