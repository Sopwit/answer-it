package com.example.answerit.core.di

import android.content.Context
import com.example.answerit.core.audio.SoundEffectManager
import com.example.answerit.core.haptics.HapticManager
import com.example.answerit.data.local.LanguageManager
import com.example.answerit.data.local.PreferencesRepository
import com.example.answerit.data.repository.QuestionRepository

class AppContainer(private val context: Context) {
    val preferencesRepository: PreferencesRepository by lazy {
        PreferencesRepository(context)
    }

    val languageManager: LanguageManager by lazy {
        LanguageManager(context)
    }

    val questionRepository: QuestionRepository by lazy {
        QuestionRepository
    }

    val soundEffectManager: SoundEffectManager by lazy {
        SoundEffectManager(context)
    }

    val hapticManager: HapticManager by lazy {
        HapticManager(context)
    }
}
