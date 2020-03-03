package com.folen.androidshowreel.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.AppCompatActivity
import com.folen.androidshowreel.R

class TextInputLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_input_layout)
    }

    fun intent(context: Context): Intent {
        return Intent(context, TextInputLayoutActivity::class.java)
    }

    @Suppress("UNUSED_PARAMETER")
    fun loginAccount(view: View) {
        Toast.makeText(applicationContext, getString(R.string.click), LENGTH_SHORT).show()
    }

    @Suppress("UNUSED_PARAMETER")
    fun createAccount(view: View) {
        Toast.makeText(applicationContext, getString(R.string.click), LENGTH_SHORT).show()
    }

}