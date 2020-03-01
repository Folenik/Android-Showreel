package com.folen.androidshowreel.activity

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.folen.androidshowreel.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_snackbar.*

class SnackBarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snackbar)

        show_snackbar_button.setOnClickListener {
            Snackbar.make(parent_view, getString(R.string.snackbar_simple), Snackbar.LENGTH_LONG).show()
        }

        show_snackbar_action_button.setOnClickListener {
            parent_view.setBackgroundColor(Color.BLUE)
            Snackbar.make(parent_view, getString(R.string.snackbar_change_background), Snackbar.LENGTH_LONG)
                    .setAction(getString(R.string.undo)) {
                        parent_view.setBackgroundColor(Color.WHITE)
                    }.show()
        }

        show_snackbar_dismiss_button.setOnClickListener {
            val snack = Snackbar.make(parent_view, getString(R.string.snackbar_dismiss), Snackbar.LENGTH_INDEFINITE)
            snack.setAction(getString(R.string.dismiss)) {
                snack.dismiss()
            }
            snack.show()
        }
    }

    fun intent(context: Context): Intent {
        return Intent(context, SnackBarActivity::class.java)
    }

}