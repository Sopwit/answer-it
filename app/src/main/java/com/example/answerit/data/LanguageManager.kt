package com.example.answerit.data

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import android.content.res.Resources
import java.util.*

class LanguageManager(private val context: Context) {
    
    companion object {
        private const val PREFS_NAME = "language_prefs"
        private const val KEY_LANGUAGE = "selected_language"
    }
    
    private val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    
    fun setLanguage(language: Language) {
        // Save language preference
        prefs.edit().putString(KEY_LANGUAGE, language.code).apply()
        
        // Apply language change
        updateResources(language)
    }
    
    fun getCurrentLanguage(): Language {
        val savedLanguage = prefs.getString(KEY_LANGUAGE, null)
        return when (savedLanguage) {
            "tr" -> Language.TURKISH
            "en" -> Language.ENGLISH
            "zh" -> Language.CHINESE
            "es" -> Language.SPANISH
            "ar" -> Language.ARABIC
            "de" -> Language.GERMAN
            "fr" -> Language.FRENCH
            "ru" -> Language.RUSSIAN
            "hi" -> Language.HINDI
            "ja" -> Language.JAPANESE
            "ko" -> Language.KOREAN
            "pt" -> Language.PORTUGUESE
            "vi" -> Language.VIETNAMESE
            else -> Language.TURKISH // Default to Turkish
        }
    }
    
    fun updateResources(language: Language) {
        val locale = when (language) {
            Language.TURKISH -> Locale("tr")
            Language.ENGLISH -> Locale("en")
            Language.CHINESE -> Locale("zh")
            Language.SPANISH -> Locale("es")
            Language.ARABIC -> Locale("ar")
            Language.GERMAN -> Locale("de")
            Language.FRENCH -> Locale("fr")
            Language.RUSSIAN -> Locale("ru")
            Language.HINDI -> Locale("hi")
            Language.JAPANESE -> Locale("ja")
            Language.KOREAN -> Locale("ko")
            Language.PORTUGUESE -> Locale("pt")
            Language.VIETNAMESE -> Locale("vi")
            Language.ITALIAN -> Locale("it")
        }
        
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