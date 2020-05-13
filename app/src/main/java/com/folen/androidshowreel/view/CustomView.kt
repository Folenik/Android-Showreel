package com.folen.androidshowreel.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.folen.androidshowreel.R
import kotlinx.android.synthetic.main.view_to_merge.view.*

class CustomView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyle: Int = 0,
        defStyleRes: Int = 0
) : LinearLayout(context, attrs, defStyle, defStyleRes) {

    init {
        LayoutInflater.from(context).inflate(R.layout.view_to_merge, this, true)
        orientation = VERTICAL

        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.custom_view_attributes, 0, 0)
            val title = resources.getText(typedArray
                    .getResourceId(R.styleable.custom_view_attributes_custom_view_title, R.string.custom_string_one))
            val image = resources.getDrawable(typedArray.getResourceId(R.styleable.custom_view_attributes_custom_view_image, R.drawable.flower))

            my_merge_textview.text = title
            my_merge_imageview.setImageDrawable(image)


            typedArray.recycle()
        }
    }
}
