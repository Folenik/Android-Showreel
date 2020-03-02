package com.folen.androidshowreel.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.folen.androidshowreel.R
import com.folen.androidshowreel.model.KotlinDataClass
import kotlinx.android.synthetic.main.activity_kotlin.*

class BottomSheetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_sheet)
    }

    fun intent(context: Context): Intent {
        return Intent(context, BottomSheetActivity::class.java)
    }
}