package com.folen.androidshowreel.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.folen.androidshowreel.R
import kotlinx.android.synthetic.main.fragment_first.*
import java.text.DateFormat
import java.util.*

class FirstFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        first_fragment_tv.text = getString(R.string.textview_fragment_with_date,
                                DateFormat.getDateTimeInstance().format(Date()).toString())
    }


}