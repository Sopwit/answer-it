package com.example.answerit.data.model

import com.example.answerit.R

enum class BackgroundTheme(
    val drawableRes: Int,
    val textColorRes: Int,
    val subTextColorRes: Int,
    val cardBgColorRes: Int,
    val cardTextColorRes: Int,
    val cardStrokeColorRes: Int,
    val primaryButtonBgRes: Int,
    val primaryButtonTextRes: Int,
    val secondaryButtonBgRes: Int,
    val secondaryButtonTextRes: Int,
    val secondaryButtonStrokeRes: Int,
    val accentColorRes: Int,
    val lifelineBgRes: Int,
    val lifelineTextRes: Int,
    val isLight: Boolean
) {
    MINIMAL_DARK(
        drawableRes = R.drawable.bg_minimal_dark,
        textColorRes = R.color.text_primary,
        subTextColorRes = R.color.text_secondary,
        cardBgColorRes = R.color.minimal_dark_card,
        cardTextColorRes = R.color.text_primary,
        cardStrokeColorRes = R.color.stroke_dark,
        primaryButtonBgRes = R.color.gold,
        primaryButtonTextRes = R.color.black,
        secondaryButtonBgRes = R.color.minimal_dark_surface,
        secondaryButtonTextRes = R.color.text_primary,
        secondaryButtonStrokeRes = R.color.stroke_dark,
        accentColorRes = R.color.gold,
        lifelineBgRes = R.color.gold,
        lifelineTextRes = R.color.black,
        isLight = false
    ),
    MINIMAL_LIGHT(
        drawableRes = R.drawable.bg_minimal_light,
        textColorRes = R.color.text_dark,
        subTextColorRes = R.color.text_dark_secondary,
        cardBgColorRes = R.color.minimal_light_card,
        cardTextColorRes = R.color.text_dark,
        cardStrokeColorRes = R.color.stroke_light,
        primaryButtonBgRes = R.color.minimal_light_primary,
        primaryButtonTextRes = R.color.white,
        secondaryButtonBgRes = R.color.card_light_bg,
        secondaryButtonTextRes = R.color.text_dark,
        secondaryButtonStrokeRes = R.color.stroke_light,
        accentColorRes = R.color.minimal_light_primary,
        lifelineBgRes = R.color.minimal_light_primary,
        lifelineTextRes = R.color.white,
        isLight = true
    ),
    GRADIENT_BLUE(
        drawableRes = R.drawable.bg_gradient_blue,
        textColorRes = R.color.text_primary,
        subTextColorRes = R.color.text_secondary,
        cardBgColorRes = R.color.minimal_dark_card,
        cardTextColorRes = R.color.text_primary,
        cardStrokeColorRes = R.color.stroke_dark,
        primaryButtonBgRes = R.color.gold,
        primaryButtonTextRes = R.color.black,
        secondaryButtonBgRes = R.color.minimal_dark_surface,
        secondaryButtonTextRes = R.color.text_primary,
        secondaryButtonStrokeRes = R.color.stroke_dark,
        accentColorRes = R.color.gold,
        lifelineBgRes = R.color.gold,
        lifelineTextRes = R.color.black,
        isLight = false
    ),
    GRADIENT_PURPLE(
        drawableRes = R.drawable.bg_gradient_purple,
        textColorRes = R.color.text_primary,
        subTextColorRes = R.color.text_secondary,
        cardBgColorRes = R.color.minimal_dark_card,
        cardTextColorRes = R.color.text_primary,
        cardStrokeColorRes = R.color.stroke_dark,
        primaryButtonBgRes = R.color.gold,
        primaryButtonTextRes = R.color.black,
        secondaryButtonBgRes = R.color.minimal_dark_surface,
        secondaryButtonTextRes = R.color.text_primary,
        secondaryButtonStrokeRes = R.color.stroke_dark,
        accentColorRes = R.color.gold,
        lifelineBgRes = R.color.gold,
        lifelineTextRes = R.color.black,
        isLight = false
    ),
    GRADIENT_GOLD(
        drawableRes = R.drawable.bg_gradient_gold,
        textColorRes = R.color.text_dark,
        subTextColorRes = R.color.text_dark_secondary,
        cardBgColorRes = R.color.gold_card_bg,
        cardTextColorRes = R.color.text_dark,
        cardStrokeColorRes = R.color.stroke_gold,
        primaryButtonBgRes = R.color.gold_primary_button,
        primaryButtonTextRes = R.color.white,
        secondaryButtonBgRes = R.color.gold_card_bg,
        secondaryButtonTextRes = R.color.text_dark,
        secondaryButtonStrokeRes = R.color.stroke_gold,
        accentColorRes = R.color.gold_accent_readable,
        lifelineBgRes = R.color.gold_primary_button,
        lifelineTextRes = R.color.white,
        isLight = true
    );

    companion object {
        fun fromName(name: String?): BackgroundTheme {
            return entries.find { it.name.equals(name, ignoreCase = true) } ?: MINIMAL_DARK
        }
    }
}
