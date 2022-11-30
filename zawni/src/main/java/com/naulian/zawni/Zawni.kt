@file:Suppress("unused")

package com.naulian.zawni

import android.content.Context
import android.util.Log
import com.google.myanmartools.TransliterateU2Z
import com.google.myanmartools.TransliterateZ2U
import com.google.myanmartools.ZawgyiDetector

private const val TAG = "Zawni"
//change unicode into device encoding
fun String.zawnify(): String {
   val z2U = TransliterateZ2U("Zawgyi to Unicode")
    val u2Z = TransliterateU2Z("Unicode to Zawgyi")
    val zSystem = Detector.detectedZawgyi()
    val zEncode = this.isZawgyi()

    if(zSystem.not() && zEncode) return z2U.convert(this)
    if(zSystem && zEncode.not()) return u2Z.convert(this)
    return this
}

fun String.isZawgyi(): Boolean {
    val score =  ZawgyiDetector().getZawgyiProbability(this , true)
    Log.i(TAG, "isZawgyi: ZawgyiProbability : $score")
    return score == 1.0
}

object Zawni {
    fun initialize(context: Context) {
        Detector.initialize(context)
    }
}