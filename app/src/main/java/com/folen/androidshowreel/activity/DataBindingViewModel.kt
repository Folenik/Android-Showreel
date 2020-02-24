package com.folen.androidshowreel.activity

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR

class DataBindingViewModel : BaseObservable() {

    private var seekBarValue: Int = 0
    private var seekBarValueToTextView = 0

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
}