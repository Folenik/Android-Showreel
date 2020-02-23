package com.folen.androidshowreel.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.appcompat.app.AppCompatActivity
import com.folen.androidshowreel.R
import kotlinx.android.synthetic.main.activity_configuration_changes.*

class ConfigurationChangesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuration_changes)
        
        button_register.setOnClickListener {
            Toast.makeText(this, getString(R.string.registered), LENGTH_LONG).show()
        }
    }

    fun intent(context: Context): Intent {
        return Intent(context, ConfigurationChangesActivity::class.java)
    }

    override fun onSaveInstanceState(extra: Bundle) {
        super.onSaveInstanceState(extra)
        extra.putString("name", et_name.text.toString())
        extra.putString("login", et_login.text.toString())
        extra.putString("password", et_password.text.toString())
        extra.putString("retype_password", et_retype_password.text.toString())
    }

    override fun onRestoreInstanceState(extra: Bundle) {
        super.onRestoreInstanceState(extra)
        if (extra != null) {
            et_name.setText(extra.getString("name"))
            et_login.setText(extra.getString("login"))
            et_password.setText(extra.getString("password"))
            et_retype_password.setText(extra.getString("retype_password"))
        }
    }
}