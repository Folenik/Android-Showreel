package com.folen.androidshowreel.util.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.folen.androidshowreel.fragment.registration.*

class RegistrationPagerAdapter internal constructor(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null

        when (position) {
            0 -> fragment = EnterEmailFragment()
            1 -> fragment = EnterPasswordFragment()
            2 -> fragment = ReEnterPasswordFragment()
            3 -> fragment = EnterNicknameFragment()
            4 -> fragment = ShowUserDataFragment()
        }
        return fragment!!
    }

    override fun getItemCount(): Int {
        return 5
    }
}
