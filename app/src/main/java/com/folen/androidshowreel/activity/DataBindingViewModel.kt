package com.folen.androidshowreel.activity

import android.graphics.Color
import android.widget.TextView
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import com.folen.androidshowreel.BR

class DataBindingViewModel : BaseObservable() {

    //1) Simple databind
    //2) Two way databinding
    //3) Custom BindingAdapter

    //1
    private var simpleDatabind = "Simple example"
    //2
    private var seekBarValue = 0
    private var seekBarValueToTextView = 0
    //3
    private var equationValue = ""


    //1
    @Bindable
    fun getSimpleDatabind(): String {
        return simpleDatabind
    }
    //---

    //2
    @Bindable
    fun getSeekBarValue(): Int {
        return seekBarValue
    }

    fun setSeekBarValue(value: Int) {
        this.seekBarValue = value
        notifyPropertyChanged(BR.seekBarValue)
        setSeekBarValueToTextView(value)
    }

    @Bindable
    fun getSeekBarValueToTextView(): Int {
        return seekBarValueToTextView
    }

    fun setSeekBarValueToTextView(value: Int) {
        this.seekBarValueToTextView = value
        notifyPropertyChanged(BR.seekBarValueToTextView)
    }
    //---

    //3
    @Bindable
    fun getEquationValue(): String {
        return equationValue
    }

    fun setEquationValue(value: String) {
        this.equationValue = value
        notifyPropertyChanged(BR.equationValue)
    }
}

@BindingAdapter("result")
fun setResult(view: TextView, text: String) {
    if ("$text" == "4") {
        view.text = "Correct answer"
        view.setTextColor(Color.parseColor("#1ad08e"))
    } else if ("$text" == "") {
        view.text = "Enter your answer"
        view.setTextColor(Color.parseColor("#000000"))
    } else {
        view.text = "Wrong answer"
        view.setTextColor(Color.parseColor("#fc7381"))
    }
}
//---