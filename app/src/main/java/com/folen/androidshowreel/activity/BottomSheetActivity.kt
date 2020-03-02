package com.folen.androidshowreel.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.AppCompatActivity
import com.folen.androidshowreel.R
import com.folen.androidshowreel.fragment.ModalBottomSheetFragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.bottom_sheet_persistent.*


lateinit var bottomSheetBehavior: BottomSheetBehavior<*>

class BottomSheetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_sheet)

        bottomSheetBehavior = BottomSheetBehavior.from(bottom_sheet_layout)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
    }

    @Suppress("UNUSED_PARAMETER")
    fun setupPersistentBottomSheet(v: View) {
        if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_HIDDEN) {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        } else {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
        }
    }

    @Suppress("UNUSED_PARAMETER")
    fun setupModalBottomSheet(v: View) {
        val bottomSheetFragment = ModalBottomSheetFragment()
        bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
    }

    @Suppress("UNUSED_PARAMETER")
    fun joinUsPersistent(v: View) {
        Toast.makeText(applicationContext, getString(R.string.bottom_sheet_persistent_button), LENGTH_SHORT).show()
    }

    fun intent(context: Context): Intent {
        return Intent(context, BottomSheetActivity::class.java)
    }
}