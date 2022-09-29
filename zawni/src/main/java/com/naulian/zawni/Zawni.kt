package com.naulian.zawni

import android.content.Context

//change unicode into device encoding
fun String.unify(): String {
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