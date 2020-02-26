package com.folen.androidshowreel.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
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

        setupSeekBar()
        setupBinding()
    }

    private fun setupSeekBar() {
        seekbar.max = 100
    }

    private fun setupBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_databind)
        val dataBindingViewModel = DataBindingViewModel()
        binding.databind = dataBindingViewModel

    }

    fun intent(context: Context): Intent {
        return Intent(context, DataBindingActivity::class.java)
    }
}