package com.ibrohimapk3.easyenglishcompose.presentation.view

import android.content.Context
import android.speech.tts.TextToSpeech
import java.util.*

class Speaker(context: Context) : TextToSpeech.OnInitListener {
    private var tts: TextToSpeech = TextToSpeech(context, this)
    private var isReady = false
    private var pendingText: String? = null
    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result = tts.setLanguage(Locale.ENGLISH)
            if (result != TextToSpeech.LANG_MISSING_DATA && result != TextToSpeech.LANG_NOT_SUPPORTED) {
                isReady = true
                pendingText?.let { speak(it) }
            }
        }
    }

    fun speak(text: String) {
        if (isReady) {
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
        } else {
            pendingText = text
        }
    }

    fun speak(text: String, speed: Float) {
        if (isReady) {
            tts.setSpeechRate(speed)
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
        } else {
            pendingText = text
        }
    }
}
