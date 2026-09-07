package com.example.answerit.data.model

enum class Language(val code: String, val displayName: String, val currencySymbol: String) {
    TURKISH("tr", "Türkçe", "₺"),
    ENGLISH("en", "English", "$"),
    CHINESE("zh", "中文", "¥"),
    SPANISH("es", "Español", "€"),
    ARABIC("ar", "العربية", "ر.س"),
    GERMAN("de", "Deutsch", "€"),
    FRENCH("fr", "Français", "€"),
    RUSSIAN("ru", "Русский", "₽"),
    HINDI("hi", "हिन्दी", "₹"),
    JAPANESE("ja", "日本語", "¥"),
    KOREAN("ko", "한국어", "₩"),
    PORTUGUESE("pt", "Português", "R$"),
    VIETNAMESE("vi", "Tiếng Việt", "₫"),
    ITALIAN("it", "Italiano", "€");

    companion object {
        fun fromCode(code: String?): Language {
            return entries.find { it.code.equals(code, ignoreCase = true) } ?: TURKISH
        }
    }
}
