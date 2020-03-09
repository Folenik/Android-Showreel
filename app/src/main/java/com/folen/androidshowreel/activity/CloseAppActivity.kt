package com.folen.androidshowreel.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class CloseAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        finish()
    }
}