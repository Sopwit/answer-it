package com.example.answerit.core.audio

import android.content.Context
import android.media.AudioAttributes
import android.media.SoundPool
import com.example.answerit.R

class SoundEffectManager(context: Context) {

    private var soundPool: SoundPool? = null
    private var correctSoundId: Int = 0
    private var wrongSoundId: Int = 0

    init {
        val audioAttributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_GAME)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .build()

        soundPool = SoundPool.Builder()
            .setMaxStreams(2)
            .setAudioAttributes(audioAttributes)
            .build().apply {
                correctSoundId = load(context, R.raw.correct_answer, 1)
                wrongSoundId = load(context, R.raw.wrong_answer, 1)
            }
    }

    fun playCorrect() {
        soundPool?.play(correctSoundId, 1f, 1f, 1, 0, 1f)
    }

    fun playWrong() {
        soundPool?.play(wrongSoundId, 1f, 1f, 1, 0, 1f)
    }

    fun release() {
        soundPool?.release()
        soundPool = null
    }
}
