package com.folen.androidshowreel.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.folen.androidshowreel.R
import com.folen.androidshowreel.fragment.CustomFragmentWithInterface
import com.folen.androidshowreel.fragment.registration.EnterEmailFragment
import com.folen.androidshowreel.util.adapter.RegistrationPagerAdapter

class SlidingRegistrationFormActivity : FragmentActivity(),  CustomFragmentWithInterface.OnButtonClickListener {

    lateinit var pager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sliding_reg_form)

        initAdapterAndViewPager()
    }

    private fun initAdapterAndViewPager() {
        pager = findViewById(R.id.registration_view_pager)
        pager.isUserInputEnabled = false

        val adapter = RegistrationPagerAdapter(this)
        pager.adapter = adapter
    }

    override fun onButtonClicked() {
        if (pager.currentItem == 3) {
            pager.currentItem = pager.currentItem + 1
        } else {
            pager.currentItem = pager.currentItem + 1
        }
    }

    fun intent(context: Context): Intent {
        return Intent(context, SlidingRegistrationFormActivity::class.java)
    }
}