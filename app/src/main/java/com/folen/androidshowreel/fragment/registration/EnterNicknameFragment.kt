package com.folen.androidshowreel.fragment.registration

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.folen.androidshowreel.R
import com.folen.androidshowreel.fragment.CustomFragmentWithInterface
import com.folen.androidshowreel.util.Const
import kotlinx.android.synthetic.main.fragment_choose_nickname.*
import kotlinx.android.synthetic.main.fragment_enter_email.*
import kotlinx.android.synthetic.main.fragment_enter_email.next_fragment_arrow
import kotlinx.android.synthetic.main.fragment_enter_password.*
import kotlinx.android.synthetic.main.fragment_first.*

class EnterNicknameFragment : CustomFragmentWithInterface() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_choose_nickname, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        next_fragment_arrow.setOnClickListener {
            putNicknameToSharedPref(enter_nickname_et.text.toString())
        }
    }

    private fun putNicknameToSharedPref(nickname: String) {
        if(enter_nickname_et.text.isNullOrEmpty()) {
            Toast.makeText(context, getString(R.string.put_nickname), Toast.LENGTH_LONG).show()
        }
        else {
            val prefs: SharedPreferences = activity!!.getSharedPreferences(Const.REGISTER_SHARED_PREF, Context.MODE_PRIVATE)
            prefs.edit().putString("nickname",nickname).commit()
            mOnButtonClickListener.onButtonClicked()
        }
    }
}
