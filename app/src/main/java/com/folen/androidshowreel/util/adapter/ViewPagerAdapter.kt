package com.folen.androidshowreel.util.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.folen.androidshowreel.fragment.FirstFragment
import com.folen.androidshowreel.fragment.SecondFragment
import com.folen.androidshowreel.fragment.ThirdFragment

class ViewPagerAdapter internal constructor(fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null

        when (position) {
            0 -> fragment = FirstFragment()
            1 -> fragment = SecondFragment()
            2 -> fragment = ThirdFragment()
        }
        return fragment!!
    }

    override fun getCount(): Int {
        return 3
    }
}
