package com.folen.androidshowreel.fragment

import android.app.Activity
import android.content.Context
import androidx.fragment.app.Fragment


open class CustomFragmentWithInterface : Fragment() {

    lateinit var mOnButtonClickListener: OnButtonClickListener

    interface OnButtonClickListener {
        fun onButtonClicked();
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mOnButtonClickListener = try {
            context as OnButtonClickListener
        } catch (e: ClassCastException) {
            throw ClassCastException((context as Activity).localClassName
                    + " must implement OnButtonClickListener")
        }
    }
}