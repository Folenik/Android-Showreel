package com.folen.androidshowreel.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.folen.androidshowreel.R;

public class BaseFragment extends Fragment {

    public AppCompatTextView mTextView;
    private View mRootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_base, container, false);
        setupViews();

        return mRootView;
    }

    public void setupViews() {
        mTextView = mRootView.findViewById(R.id.base_fragment_textview);
    }

    public void setTextViewText(String value){
        mTextView.setText(value);
    }

}
