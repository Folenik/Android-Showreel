package com.folen.androidshowreel.fragment.registration

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.folen.androidshowreel.R
import com.folen.androidshowreel.fragment.CustomFragmentWithInterface
import com.folen.androidshowreel.util.Const
import kotlinx.android.synthetic.main.fragment_reenter_password.*


class ReEnterPasswordFragment : CustomFragmentWithInterface() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_reenter_password, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        next_fragment_arrow.setOnClickListener {
            checkIfPasswordIsProper()
        }
    }

    private fun checkIfPasswordIsProper() {
        val prefs: SharedPreferences = activity!!.getSharedPreferences(Const.REGISTER_SHARED_PREF, Context.MODE_PRIVATE)

        if (reenter_password_et.text.isNullOrEmpty()) {
            Toast.makeText(context, getString(R.string.put_password), Toast.LENGTH_LONG).show()
        } else if (!reenter_password_et.text.toString().equals(prefs.getString("password",""))) {
            Toast.makeText(context, getString(R.string.wrong_password), Toast.LENGTH_LONG).show()
            Log.i("Password1",reenter_password_et.text.toString())
            Log.i("Password2",prefs.getString("password",""))
        } else {
            mOnButtonClickListener.onButtonClicked()
        }
    }
}