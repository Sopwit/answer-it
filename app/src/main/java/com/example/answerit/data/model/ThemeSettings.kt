package com.example.answerit.data.model

import com.example.answerit.R

enum class BackgroundTheme(
    val drawableRes: Int,
    val textColorRes: Int,
    val cardBgColorRes: Int,
    val cardTextColorRes: Int
) {
    MINIMAL_DARK(R.drawable.bg_minimal_dark, R.color.text_primary, R.color.minimal_dark_surface, R.color.text_primary),
    MINIMAL_LIGHT(R.drawable.bg_minimal_light, R.color.text_dark, R.color.card_light_bg, R.color.text_dark),
    GRADIENT_BLUE(R.drawable.bg_gradient_blue, R.color.text_primary, R.color.minimal_dark_surface, R.color.text_primary),
    GRADIENT_PURPLE(R.drawable.bg_gradient_purple, R.color.text_primary, R.color.minimal_dark_surface, R.color.text_primary),
    GRADIENT_GOLD(R.drawable.bg_gradient_gold, R.color.text_dark, R.color.card_light_bg, R.color.text_dark);

    companion object {
        fun fromName(name: String?): BackgroundTheme {
            return entries.find { it.name.equals(name, ignoreCase = true) } ?: MINIMAL_DARK
        }
    }
}
