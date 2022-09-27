package com.naulian.zawni

import android.content.Context

fun String.zawnify(): String {
    val detectedZawgyi = Detector.detectedZawgyi()
    if (detectedZawgyi) {
        return Converter.uniToZg(this)
    }
    return this
}


object Zawni {
    fun initialize(context: Context){
        Detector.initialize(context)
    }
}