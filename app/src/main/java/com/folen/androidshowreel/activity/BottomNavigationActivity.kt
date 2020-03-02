package com.folen.androidshowreel.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.folen.androidshowreel.R
import com.folen.androidshowreel.fragment.FirstFragment
import com.folen.androidshowreel.fragment.SecondFragment
import com.folen.androidshowreel.fragment.ThirdFragment
import kotlinx.android.synthetic.main.activity_bottom_navigation.*

class BottomNavigationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)

        if (savedInstanceState == null) {
            val fragment = FirstFragment()
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()
        }

        listenToBottomNavigation()
    }

    private fun listenToBottomNavigation() {
        bottom_navigation.setOnNavigationItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.navigation_first -> {
                    val fragment = FirstFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_second -> {
                    val fragment = SecondFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_third -> {
                    val fragment = ThirdFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()
                    return@setOnNavigationItemSelectedListener true
                }
                else -> {
                    return@setOnNavigationItemSelectedListener false
                }
            }
        }
    }

    fun intent(context: Context): Intent {
        return Intent(context, BottomNavigationActivity::class.java)
    }
}