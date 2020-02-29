package com.folen.androidshowreel.fragment.registration

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import com.folen.androidshowreel.R
import com.folen.androidshowreel.fragment.CustomFragmentWithInterface
import com.folen.androidshowreel.util.Const
import kotlinx.android.synthetic.main.fragment_enter_email.*


class EnterEmailFragment : CustomFragmentWithInterface() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_enter_email, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        next_fragment_button.setOnClickListener {
            checkIfEmailIsProper()
        }
    }

    private fun checkIfEmailIsProper() {
        if (android.util.Patterns.EMAIL_ADDRESS.matcher(enter_email_et.text.toString()).matches()) {
            mOnButtonClickListener.onButtonClicked()
            putEmailToSharedPref(enter_email_et.text.toString())
        } else if (enter_email_et.text.isNullOrEmpty()) {
            Toast.makeText(context, getString(R.string.put_email), LENGTH_LONG).show()
        } else {
            Toast.makeText(context, getString(R.string.wrong_email), LENGTH_LONG).show()
        }
    }

    private fun putEmailToSharedPref(email: String) {
        val prefs: SharedPreferences = activity!!.getSharedPreferences(Const.REGISTER_SHARED_PREF, MODE_PRIVATE)
        prefs.edit().putString("email", email).commit()
    }
}