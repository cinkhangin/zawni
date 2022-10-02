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

        binding.apply {
            edtInput.addTextChangedListener {
                it?.let {
                    val text = it.toString().zawnify()
                    txtOutput.text = text
                }
            }
        }
    }
}