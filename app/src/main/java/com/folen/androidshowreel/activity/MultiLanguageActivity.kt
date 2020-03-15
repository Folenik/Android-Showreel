package com.folen.androidshowreel.activity

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.folen.androidshowreel.R
import kotlinx.android.synthetic.main.activity_multi_language.*
import java.util.*


class MultiLanguageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initSharedPref()

        setContentView(R.layout.activity_multi_language)

        et_password.addTextChangedListener(object : TextWatcher {
            var inputTypeChanged = false

            override fun afterTextChanged(s: Editable) {
                if (s.length > 0) {
                    if (!inputTypeChanged) {
                        et_password.setInputType(InputType.TYPE_CLASS_TEXT or
                                InputType.TYPE_TEXT_VARIATION_PASSWORD or
                                InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS)

                        et_password.setSelection(s.length)
                        inputTypeChanged = true
                    }
                } else {
                    et_password.setInputType(InputType.TYPE_CLASS_TEXT or
                            InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS)
                    inputTypeChanged = false
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })

        et_retype_password.addTextChangedListener(object : TextWatcher {
            var inputTypeChanged = false

            override fun afterTextChanged(s: Editable) {
                if (s.length > 0) {
                    if (!inputTypeChanged) {
                        et_retype_password.setInputType(InputType.TYPE_CLASS_TEXT or
                                InputType.TYPE_TEXT_VARIATION_PASSWORD or
                                InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS)

                        et_retype_password.setSelection(s.length)
                        inputTypeChanged = true
                    }
                } else {
                    et_retype_password.setInputType(InputType.TYPE_CLASS_TEXT or
                            InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS)
                    inputTypeChanged = false
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })
    }

    private fun initSharedPref() {
        sharedPref = getSharedPreferences("My_Preferences", Context.MODE_PRIVATE)
        if (!sharedPref.contains("initialized")) {
            sharedPref.edit().putBoolean("initialized", true).commit();
        } else {
            getLanguagePref()
        }
    }

    private fun getLanguagePref() {
        val language = sharedPref.getString("language", "en") as String
        setLanguage(language)
    }

    @Suppress("UNUSED_PARAMETER")
    fun registerAccount(view: View) {
        Toast.makeText(applicationContext, getString(R.string.hello_tv), LENGTH_SHORT).show()
    }

    @Suppress("UNUSED_PARAMETER")
    fun changeLanguage(view: View) {
        val languages = arrayOf("English", "العربية", "Deutsch", "Français", "Polski")
        val builder = AlertDialog.Builder(this)
        builder.setTitle(getString(R.string.button_change_language))
        builder.setSingleChoiceItems(languages, -1) { _, which ->
            when (which) {
                0 -> setLanguage("en")
                1 -> setLanguage("ar")
                2 -> setLanguage("de")
                3 -> setLanguage("fr")
                4 -> setLanguage("pl")
            }
            recreate()
        }
        builder.show()
    }

    @SuppressWarnings("DEPRECATION")
    private fun setLanguage(language: String) {
        val locale = Locale(language)
        Locale.setDefault(locale)

        val config = Configuration()
        config.setLocale(locale)
        config.setLayoutDirection(locale)

        baseContext.resources.updateConfiguration(config,
                baseContext.resources.displayMetrics)

        sharedPref.edit().putString("language", language).commit()
    }

    fun intent(context: Context): Intent {
        return Intent(context, MultiLanguageActivity::class.java)
    }

}