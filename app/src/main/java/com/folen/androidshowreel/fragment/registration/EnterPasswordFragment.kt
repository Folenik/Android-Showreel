package com.folen.androidshowreel.fragment.registration

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.folen.androidshowreel.R
import com.folen.androidshowreel.fragment.CustomFragmentWithInterface
import com.folen.androidshowreel.util.Const
import kotlinx.android.synthetic.main.fragment_enter_password.*


class EnterPasswordFragment : CustomFragmentWithInterface() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_enter_password, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        next_fragment_button.setOnClickListener {
            checkIfPasswordIsProper()
        }
    }

    private fun checkIfPasswordIsProper() {
        if (enter_password_et.text.isNullOrEmpty()) {
            Toast.makeText(context, getString(R.string.put_password), Toast.LENGTH_LONG).show()
        } else {
            mOnButtonClickListener.onButtonClicked()
            putPasswordToSharedPref(enter_password_et.text.toString())
        }
    }

    private fun putPasswordToSharedPref(password: String) {
        val prefs: SharedPreferences = activity!!.getSharedPreferences(Const.REGISTER_SHARED_PREF, Context.MODE_PRIVATE)
        prefs.edit().putString("password", password).commit()
    }
}


