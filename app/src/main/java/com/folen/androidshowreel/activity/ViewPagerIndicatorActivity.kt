package com.folen.androidshowreel.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.folen.androidshowreel.R
import com.folen.androidshowreel.util.adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_viewpager_indicator.*

class ViewPagerIndicatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewpager_indicator)

        initAdapterAndViewPagerAndTabLayout()
    }

    private fun initAdapterAndViewPagerAndTabLayout() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        view_pager.adapter = adapter

        tab_layout.setupWithViewPager(view_pager, true)
    }

    fun intent(context: Context): Intent {
        return Intent(context, ViewPagerIndicatorActivity::class.java)
    }

}