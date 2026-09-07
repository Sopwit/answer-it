package com.example.answerit.data.local

import android.content.Context
import android.content.res.Configuration
import com.example.answerit.data.model.Language
import java.util.Locale

class LanguageManager(private val context: Context) {

    private val prefsRepo = PreferencesRepository(context)

    fun setLanguage(language: Language) {
        val currentSettings = prefsRepo.getAppSettings()
        prefsRepo.saveAppSettings(currentSettings.copy(language = language))
        updateResources(language)
    }

    fun getCurrentLanguage(): Language {
        return prefsRepo.getAppSettings().language
    }

    @Suppress("DEPRECATION")
    fun updateResources(language: Language) {
        val locale = Locale(language.code)
        Locale.setDefault(locale)

        val config = Configuration(context.resources.configuration)
        config.setLocale(locale)
        context.createConfigurationContext(config)
        context.resources.updateConfiguration(config, context.resources.displayMetrics)
    }

    fun applySavedLanguage() {
        val savedLanguage = getCurrentLanguage()
        updateResources(savedLanguage)
    }
}
