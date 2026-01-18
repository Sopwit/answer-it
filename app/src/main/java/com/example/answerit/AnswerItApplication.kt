package com.example.answerit

import android.app.Application
import com.example.answerit.data.LanguageManager

class AnswerItApplication : Application() {
    
    override fun onCreate() {
        super.onCreate()

        val prefs = getSharedPreferences("language_prefs", MODE_PRIVATE)
        val isFirstLaunch = prefs.getBoolean("is_first_launch", true)
        if (isFirstLaunch) {
            prefs.edit()
                .putString("selected_language", com.example.answerit.data.Language.ENGLISH.code)
                .putBoolean("is_first_launch", false)
                .apply()
        }
        // Initialize language manager and apply saved language at app startup
        val languageManager = com.example.answerit.data.LanguageManager(this)
        languageManager.applySavedLanguage()
    }
} 