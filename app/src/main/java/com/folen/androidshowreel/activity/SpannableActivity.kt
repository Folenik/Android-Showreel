package com.folen.androidshowreel.activity

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface.BOLD
import android.os.Build
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.method.LinkMovementMethod
import android.text.style.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.folen.androidshowreel.R
import com.folen.androidshowreel.util.Const.WEBVIEW_PAGE_URL
import kotlinx.android.synthetic.main.activity_spannable.*

class SpannableActivity : AppCompatActivity() {

    private lateinit var spannableTypeOne: SpannableStringBuilder
    private lateinit var spannableTypeTwo: SpannableStringBuilder
    private lateinit var spannableTypeThree: SpannableStringBuilder
    private lateinit var spannableTypeFour: SpannableStringBuilder

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spannable)

        setSpannables()
        assignSpannablesToTextViews()
    }


    @RequiresApi(Build.VERSION_CODES.P)
    private fun setSpannables() {
        spannableTypeOne = SpannableStringBuilder(getString(R.string.span_string_type_one))
        spannableTypeOne.apply {
            this.setSpan(ForegroundColorSpan(Color.RED),
                    6, 9,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            this.setSpan(StyleSpan(BOLD),
                    0, 4,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            this.setSpan(ForegroundColorSpan(Color.RED),
                    11, spannableTypeOne.length,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            this.setSpan(StyleSpan(BOLD),
                    11, spannableTypeOne.length,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            this.setSpan(AbsoluteSizeSpan(24, true),
                    0, spannableTypeOne.length,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        }
        spannableTypeTwo = SpannableStringBuilder(getString(R.string.span_string_type_two))
        spannableTypeTwo.apply {
            this.setSpan(URLSpan(WEBVIEW_PAGE_URL),
                    10, spannableTypeTwo.length,
                    Spannable.SPAN_INCLUSIVE_INCLUSIVE)
            this.setSpan(AbsoluteSizeSpan(24, true),
                    0, spannableTypeTwo.length,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        }
        spannableTypeThree = SpannableStringBuilder(getString(R.string.span_string_type_three))
        spannableTypeThree.apply {
            this.setSpan(BulletSpan(20, Color.GREEN, 15),
                    11, 13,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            this.setSpan(BulletSpan(20, Color.GREEN, 15),
                    16, spannableTypeThree.length,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            this.setSpan(AbsoluteSizeSpan(32, true),
                    0, 4,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            this.setSpan(AbsoluteSizeSpan(24, true),
                    5, spannableTypeOne.length,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        }
        spannableTypeFour = SpannableStringBuilder(getString(R.string.span_string_type_four))
        spannableTypeFour.apply {
            this.setSpan(ImageSpan(applicationContext, R.drawable.ic_android, ImageSpan.ALIGN_BOTTOM),
                    11, spannableTypeFour.length,
                    Spannable.SPAN_INCLUSIVE_EXCLUSIVE)
        }
    }

    private fun assignSpannablesToTextViews() {
        spannable_first_textview.text = spannableTypeOne

        spannable_second_textview.text = spannableTypeTwo
        spannable_second_textview.isClickable = true
        spannable_second_textview.movementMethod = LinkMovementMethod.getInstance()

        spannable_third_textview.text = spannableTypeThree
        spannable_fourth_textview.text = spannableTypeFour
    }

    fun intent(context: Context): Intent {
        return Intent(context, SpannableActivity::class.java)
    }
}