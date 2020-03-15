package com.folen.androidshowreel.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.folen.androidshowreel.R

class DeathToolsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_death_tools)
    }

    fun intent(context: Context): Intent {
        return Intent(context, DeathToolsActivity::class.java)
    }
}