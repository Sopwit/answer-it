package com.example.answerit.data.local

import android.content.Context
import android.content.SharedPreferences
import com.example.answerit.data.model.AppSettings
import com.example.answerit.data.model.BackgroundTheme
import com.example.answerit.data.model.Language
import com.example.answerit.data.model.PlayerProfile

class PreferencesRepository(context: Context) {

    private val prefs: SharedPreferences =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    companion object {
        private const val PREFS_NAME = "answerit_prefs"
        private const val KEY_THEME = "key_theme"
        private const val KEY_LANGUAGE = "selected_language"
        private const val KEY_SOUND = "key_sound"
        private const val KEY_VIBRATION = "key_vibration"
        private const val KEY_PLAYER_NAME = "key_player_name"
        private const val KEY_BEST_SCORE = "key_best_score"
        private const val KEY_GAMES_PLAYED = "key_games_played"
        private const val KEY_TOTAL_WINNINGS = "key_total_winnings"
        private const val KEY_LAST_PLAYED = "key_last_played"
        private const val KEY_FIRST_LAUNCH = "is_first_launch"
    }

    fun isFirstLaunch(): Boolean = prefs.getBoolean(KEY_FIRST_LAUNCH, true)

    fun setFirstLaunchCompleted() {
        prefs.edit().putBoolean(KEY_FIRST_LAUNCH, false).apply()
    }

    fun getAppSettings(): AppSettings {
        val themeName = prefs.getString(KEY_THEME, BackgroundTheme.MINIMAL_DARK.name)
        val langCode = prefs.getString(KEY_LANGUAGE, Language.TURKISH.code)
        val sound = prefs.getBoolean(KEY_SOUND, true)
        val vibration = prefs.getBoolean(KEY_VIBRATION, true)

        return AppSettings(
            backgroundTheme = BackgroundTheme.fromName(themeName),
            language = Language.fromCode(langCode),
            soundEnabled = sound,
            vibrationEnabled = vibration
        )
    }

    fun saveAppSettings(settings: AppSettings) {
        prefs.edit()
            .putString(KEY_THEME, settings.backgroundTheme.name)
            .putString(KEY_LANGUAGE, settings.language.code)
            .putBoolean(KEY_SOUND, settings.soundEnabled)
            .putBoolean(KEY_VIBRATION, settings.vibrationEnabled)
            .apply()
    }

    fun getPlayerProfile(): PlayerProfile {
        return PlayerProfile(
            name = prefs.getString(KEY_PLAYER_NAME, "Yarışmacı") ?: "Yarışmacı",
            bestScore = prefs.getInt(KEY_BEST_SCORE, 0),
            gamesPlayed = prefs.getInt(KEY_GAMES_PLAYED, 0),
            totalWinnings = prefs.getLong(KEY_TOTAL_WINNINGS, 0L),
            lastPlayedDate = prefs.getLong(KEY_LAST_PLAYED, 0L)
        )
    }

    fun savePlayerProfile(profile: PlayerProfile) {
        prefs.edit()
            .putString(KEY_PLAYER_NAME, profile.name)
            .putInt(KEY_BEST_SCORE, profile.bestScore)
            .putInt(KEY_GAMES_PLAYED, profile.gamesPlayed)
            .putLong(KEY_TOTAL_WINNINGS, profile.totalWinnings)
            .putLong(KEY_LAST_PLAYED, profile.lastPlayedDate)
            .apply()
    }

    fun resetPlayerStats() {
        val currentName = prefs.getString(KEY_PLAYER_NAME, "Yarışmacı") ?: "Yarışmacı"
        prefs.edit()
            .putString(KEY_PLAYER_NAME, currentName)
            .putInt(KEY_BEST_SCORE, 0)
            .putInt(KEY_GAMES_PLAYED, 0)
            .putLong(KEY_TOTAL_WINNINGS, 0L)
            .putLong(KEY_LAST_PLAYED, 0L)
            .apply()
    }
}
