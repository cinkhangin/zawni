package com.naulian.zawni

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.ViewGroup
import android.widget.TextView

object Detector {
    private var isFontInUniCode: Boolean? = null

    @SuppressLint("SetTextI18n")
    fun initialize(context: Context) {
        if (isFontInUniCode != null) {
            Log.i("Detector", "Detector was already initialized.")
            return
        }


        val wrapContent = ViewGroup.LayoutParams.WRAP_CONTENT
        val textView = TextView(context, null)
        textView.apply {
            layoutParams = ViewGroup.LayoutParams(wrapContent, wrapContent)

            text = "\u1000"
            measure(wrapContent, wrapContent)
            val length1 = measuredWidth

            text = "\u1000\u1039\u1000"
            measure(wrapContent, wrapContent)
            val length2 = measuredWidth

            isFontInUniCode = length1 == length2
        }
    }

    fun detectedZawgyi(): Boolean {
        if (null == isFontInUniCode)
            throw UnsupportedOperationException("Detector was not initialized.")
        return isFontInUniCode?.not() ?: false
    }
}