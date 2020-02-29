package com.folen.androidshowreel.fragment.registration

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.folen.androidshowreel.R
import com.folen.androidshowreel.util.Const
import kotlinx.android.synthetic.main.fragment_show_user_data.*


class ShowUserDataFragment() : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_show_user_data, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        retrieveDataAndSetTextViews()
    }

    private fun retrieveDataAndSetTextViews() {
        val prefs: SharedPreferences = activity!!.getSharedPreferences(Const.REGISTER_SHARED_PREF, Context.MODE_PRIVATE)
        val password: String = prefs.getString("password", "password")
        var newPassword: String = ""

        email_textview.text = prefs.getString("email", "email")
        nickname_textview.text = prefs.getString("nickname", "nickname")

        for (i in 0..password.length - 1 step 1) {
            if (i == 0 || i == password.length - 1) {
                newPassword += password.get(i)
            } else {
                newPassword += "*"
            }
        }
        password_textview.text = newPassword
    }
}