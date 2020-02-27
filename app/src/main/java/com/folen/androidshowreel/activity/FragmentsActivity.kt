package com.folen.androidshowreel.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.folen.androidshowreel.R
import com.folen.androidshowreel.base.BaseActivity


class FragmentsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragments)
    }

    fun intent(context: Context): Intent {
        return Intent(context, FragmentsActivity::class.java)
    }
}