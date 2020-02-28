package com.folen.androidshowreel.fragment.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.folen.androidshowreel.R
import com.folen.androidshowreel.fragment.CustomFragmentWithInterface
import kotlinx.android.synthetic.main.fragment_enter_email.*


class EnterEmailFragment : CustomFragmentWithInterface() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_enter_email, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        next_fragment_arrow.setOnClickListener {
            mOnButtonClickListener.onButtonClicked()
        }
    }
}