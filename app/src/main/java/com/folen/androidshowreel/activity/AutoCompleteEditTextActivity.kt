package com.folen.androidshowreel.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.AppCompatActivity
import com.folen.androidshowreel.R
import kotlinx.android.synthetic.main.activity_autocomplete_edittext.*


class AutoCompleteEditTextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_autocomplete_edittext)

        setupAutoCompleteEditText()
    }

    private fun setupAutoCompleteEditText() {
        val adapter: ArrayAdapter<String> = ArrayAdapter(this,
                android.R.layout.simple_spinner_dropdown_item, resources.getStringArray(R.array.countries_array))
        autocomplete_tv.setAdapter(adapter)

        autocomplete_tv.setOnItemClickListener { parent, _, position, _ ->
            val selectedItem = parent.getItemAtPosition(position).toString()
            Toast.makeText(applicationContext, selectedItem, LENGTH_SHORT).show()

            val inputMethodManager = applicationContext.getSystemService(android.content.Context.INPUT_METHOD_SERVICE) as? InputMethodManager
            if (currentFocus != null) {
                inputMethodManager?.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
            }
        }
    }


    fun intent(context: Context): Intent {
        return Intent(context, AutoCompleteEditTextActivity::class.java)
    }
}