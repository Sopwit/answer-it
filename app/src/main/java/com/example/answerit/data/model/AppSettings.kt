package com.example.answerit.data.model

data class AppSettings(
    val backgroundTheme: BackgroundTheme = BackgroundTheme.MINIMAL_DARK,
    val language: Language = Language.TURKISH,
    val soundEnabled: Boolean = true,
    val vibrationEnabled: Boolean = true
)
