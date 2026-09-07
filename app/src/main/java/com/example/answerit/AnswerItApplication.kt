package com.example.answerit

import android.app.Application
import com.example.answerit.core.di.AppContainer
import com.example.answerit.data.model.Language

class AnswerItApplication : Application() {

    lateinit var container: AppContainer
        private set

    override fun onCreate() {
        super.onCreate()
        container = AppContainer(this)

        if (container.preferencesRepository.isFirstLaunch()) {
            val appSettings = container.preferencesRepository.getAppSettings().copy(language = Language.TURKISH)
            container.preferencesRepository.saveAppSettings(appSettings)
            container.preferencesRepository.setFirstLaunchCompleted()
        }

        container.languageManager.applySavedLanguage()
    }
}
