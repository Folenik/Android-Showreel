package com.folen.androidshowreel.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.Bindable
import androidx.databinding.DataBindingUtil
import com.folen.androidshowreel.R
import com.folen.androidshowreel.databinding.ActivityDatabindBinding
import kotlinx.android.synthetic.main.activity_databind.*


private var seekBarValue: Int = 0
lateinit var binding: ActivityDatabindBinding

class DataBindingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_databind)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_databind)

        setupSeekBar()
    }

    fun setupSeekBar() {
        seekbar.max = 100
    }

    @Bindable
    fun getSeekBarValue(): String {
        return Int.toString(seekBarValue)
    }

    fun setSeekBarValue(int value) {
        seekBarValue = value
        notifyPropertyChanged(binding.seekbar)
    }

    fun intent(context: Context): Intent {
        return Intent(context, DataBindingActivity::class.java)
    }
}