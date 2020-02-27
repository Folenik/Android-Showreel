package com.folen.androidshowreel.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.folen.androidshowreel.R
import kotlinx.android.synthetic.main.fragment_first_dialog.*
import kotlinx.android.synthetic.main.fragment_second.*


class FirstDialogFragment : DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_first_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ok_button.setOnClickListener {
            val fragment: SecondFragment = activity!!.supportFragmentManager.findFragmentById(R.id.fragment_bot_left) as SecondFragment
            fragment.your_number_textview.text = number_et.text
            dialog!!.dismiss()
        }

        cancel_button.setOnClickListener {
            dialog!!.dismiss()
        }
    }
}