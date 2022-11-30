package com.naulian.zawni

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.naulian.zawni.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var viewBinding : ActivityMainBinding? = null
    private val binding get() = viewBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Zawni.initialize(this)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val test = "ဆိုတဲ့စကားလုံး အဓိပ္ပါယ်ကဘာလဲ"
        val unicode = "အပြည်ပြည်ဆိုင်ရာ လူ့အခွင့်အရေး ကြေညာစာတမ်း"
        val zawgyi = "အျပည္ျပည္ဆိုင္ရာ လူ႔အခြင့္အေရး ေၾကညာစာတမ္း"

        binding.apply {
            txtOutput.text = test.zawnify()
            edtInput.addTextChangedListener {
                it?.let {
                    val text = it.toString()
                    txtOutput.text = text.zawnify()
                }
            }
        }
    }
}