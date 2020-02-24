package com.folen.androidshowreel.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.folen.androidshowreel.R
import com.folen.androidshowreel.databinding.ActivityDatabindBinding
import kotlinx.android.synthetic.main.activity_databind.*

lateinit var binding: ActivityDatabindBinding

class DataBindingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_databind)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_databind)

        setupSeekBar()
        val dataBindingViewModel = DataBindingViewModel()
        binding.databind = dataBindingViewModel
    }

    fun setupSeekBar() {
        seekbar.max = 100
    }

    fun intent(context: Context): Intent {
        return Intent(context, DataBindingActivity::class.java)
    }
}