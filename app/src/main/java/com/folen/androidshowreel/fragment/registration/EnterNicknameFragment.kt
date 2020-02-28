package com.folen.androidshowreel.fragment.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.folen.androidshowreel.R
import com.folen.androidshowreel.fragment.CustomFragmentWithInterface
import kotlinx.android.synthetic.main.fragment_choose_nickname.*
import kotlinx.android.synthetic.main.fragment_enter_email.*
import kotlinx.android.synthetic.main.fragment_enter_email.next_fragment_arrow
import kotlinx.android.synthetic.main.fragment_first.*

class EnterNicknameFragment : CustomFragmentWithInterface() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_choose_nickname, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        next_fragment_arrow.setOnClickListener {
            mOnButtonClickListener.onButtonClicked()
        }

    }


}