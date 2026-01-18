package com.example.answerit.data

import com.example.answerit.R

enum class BackgroundTheme(
    val drawableRes: Int,
    val textColorRes: Int,
    val cardBgColorRes: Int,
    val cardTextColorRes: Int
) {
    MINIMAL_DARK(R.drawable.bg_minimal_dark, R.color.text_primary, R.color.minimal_dark_surface, R.color.text_primary),
    MINIMAL_LIGHT(R.drawable.bg_minimal_light, R.color.text_dark, R.color.card_light_bg, R.color.text_black),
    GRADIENT_BLUE(R.drawable.bg_gradient_blue, R.color.text_primary, R.color.minimal_dark_surface, R.color.text_primary),
    GRADIENT_PURPLE(R.drawable.bg_gradient_purple, R.color.text_primary, R.color.minimal_dark_surface, R.color.text_primary),
    GRADIENT_GOLD(R.drawable.bg_gradient_gold, R.color.text_dark, R.color.card_light_bg, R.color.text_black)
}

enum class Language(val code: String, val displayName: String) {
    TURKISH("tr", "Türkçe"),
    ENGLISH("en", "English"),
    CHINESE("zh", "中文"),
    SPANISH("es", "Español"),
    ARABIC("ar", "العربية"),
    GERMAN("de", "Deutsch"),
    FRENCH("fr", "Français"),
    RUSSIAN("ru", "Русский"),
    HINDI("hi", "हिन्दी"),
    JAPANESE("ja", "日本語"),
    KOREAN("ko", "한국어"),
    PORTUGUESE("pt", "Português"),
    VIETNAMESE("vi", "Tiếng Việt"),
    ITALIAN("it", "Italiano")
} 