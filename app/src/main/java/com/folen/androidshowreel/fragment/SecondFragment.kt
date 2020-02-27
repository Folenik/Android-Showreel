package com.folen.androidshowreel.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.folen.androidshowreel.R
import kotlinx.android.synthetic.main.fragment_second.*


class SecondFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        show_dialog_button.setOnClickListener {
            val dialog = FirstDialogFragment()
            dialog.setTargetFragment(this@SecondFragment, 1)
            dialog.show(fragmentManager!!, "MyCustomDialog")
        }
    }
}