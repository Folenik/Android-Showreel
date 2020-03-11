package com.folen.androidshowreel.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.folen.androidshowreel.R
import kotlinx.android.synthetic.main.activity_basic_animations.*

class BasicAnimationsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_animations)
    }

    fun intent(context: Context): Intent {
        return Intent(context, BasicAnimationsActivity::class.java)
    }

    @Suppress("UNUSED_PARAMETER")
    fun rotateAnimation(view: View) {
        val animation = AnimationUtils.loadAnimation(this, R.anim.rotate)
        m_textview.startAnimation(animation)
    }

    @Suppress("UNUSED_PARAMETER")
    fun bounceAnimation(view: View) {
        val animation = AnimationUtils.loadAnimation(this, R.anim.bounce)
        m_textview.startAnimation(animation)
    }

    @Suppress("UNUSED_PARAMETER")
    fun zoomInAnimation(view: View) {
        val animation = AnimationUtils.loadAnimation(this, R.anim.zoom_in)
        m_textview.startAnimation(animation)
    }

    @Suppress("UNUSED_PARAMETER")
    fun zoomOutAnimation(view: View) {
        val animation = AnimationUtils.loadAnimation(this, R.anim.zoom_out)
        m_textview.startAnimation(animation)
    }

    @Suppress("UNUSED_PARAMETER")
    fun slideDownAnimation(view: View) {
        val animation = AnimationUtils.loadAnimation(this, R.anim.slide_down)
        m_textview.startAnimation(animation)
    }

    @Suppress("UNUSED_PARAMETER")
    fun slideUpAnimation(view: View) {
        val animation = AnimationUtils.loadAnimation(this, R.anim.slide_up)
        m_textview.startAnimation(animation)
    }

    @Suppress("UNUSED_PARAMETER")
    fun fadeOutAnimation(view: View) {
        val animation = AnimationUtils.loadAnimation(this, R.anim.fade_out)
        m_textview.startAnimation(animation)
    }

    @Suppress("UNUSED_PARAMETER")
    fun fadeInAnimation(view: View) {
        val animation = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        m_textview.startAnimation(animation)
    }
}