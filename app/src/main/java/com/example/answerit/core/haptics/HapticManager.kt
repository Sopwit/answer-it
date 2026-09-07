package com.example.answerit.core.haptics

import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager

class HapticManager(private val context: Context) {

    @Suppress("DEPRECATION")
    private val vibrator: Vibrator? by lazy {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val vibratorManager =
                context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as? VibratorManager
            vibratorManager?.defaultVibrator
        } else {
            context.getSystemService(Context.VIBRATOR_SERVICE) as? Vibrator
        }
    }

    fun vibrateError(durationMs: Long = 300) {
        try {
            vibrator?.let {
                if (it.hasVibrator()) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        it.vibrate(
                            VibrationEffect.createOneShot(
                                durationMs,
                                VibrationEffect.DEFAULT_AMPLITUDE
                            )
                        )
                    } else {
                        @Suppress("DEPRECATION")
                        it.vibrate(durationMs)
                    }
                }
            }
        } catch (_: Exception) {
            // Ignore
        }
    }
}
