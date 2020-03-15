package com.folen.androidshowreel.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.folen.androidshowreel.R

class TakePhotoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_take_photo)
    }

    fun intent(context: Context): Intent {
        return Intent(context, TakePhotoActivity::class.java)
    }
}