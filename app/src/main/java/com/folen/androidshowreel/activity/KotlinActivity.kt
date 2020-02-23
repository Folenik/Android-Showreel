package com.folen.androidshowreel.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.folen.androidshowreel.R
import com.folen.androidshowreel.model.KotlinDataClass
import kotlinx.android.synthetic.main.activity_kotlin.*

val person = KotlinDataClass("Kamil", 24)

class KotlinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)

        setupDataClass()
        setupTextView()
    }

    private fun setupDataClass() {
        person.apply { age = convertAgeToYearWhenBorn() }
    }

    private fun setupTextView() {
        m_textview.text = getString(R.string.textview_was_born, person.name, person.age)
    }

    fun intent(context: Context): Intent {
        return Intent(context, KotlinActivity::class.java)
    }

    private fun KotlinDataClass.convertAgeToYearWhenBorn(): Int {
        return 2020 - age
    }
}