package com.folen.androidshowreel.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.appcompat.app.AppCompatActivity
import com.folen.androidshowreel.R
import kotlinx.android.synthetic.main.activity_shared_pref.*

lateinit var sharedPref: SharedPreferences

class SharedPrefActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_pref)

        initSharedPref()
        setupSeekBar()

        save_seekbar_button.setOnClickListener() {
            getValueAndStoreIt()
        }
    }

    private fun initSharedPref() {
        sharedPref = getSharedPreferences("My_Preferences", Context.MODE_PRIVATE)
        if (!sharedPref.contains("initialized")) {
            sharedPref.edit().putBoolean("initialized", true).commit();
        } else {
            getSeekBarValuesFromSharedPref()
        }
    }

    private fun setupSeekBar() {
        seek_bar.max = 100
    }

    private fun getValueAndStoreIt() {
        sharedPref.edit().putInt("seekbar_value", seek_bar.progress).commit()
        sharedPref.edit().putInt("times_saved", sharedPref.getInt("times_saved", 0) + 1).commit()
        Toast.makeText(this, getString(R.string.seek_bar_default_value), LENGTH_LONG).show()

        getSeekBarValuesFromSharedPref()
    }

    private fun getSeekBarValuesFromSharedPref() {
        seek_bar.progress = sharedPref.getInt("seekbar_value", 0)
        m_textview.text = getString(R.string.textview_seek_bar_changes,
                sharedPref.getInt("seekbar_value", 0),
                sharedPref.getInt("times_saved", 0))
    }

    fun intent(context: Context): Intent {
        return Intent(context, SharedPrefActivity::class.java)
    }
}