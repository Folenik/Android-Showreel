package com.folen.androidshowreel.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.folen.androidshowreel.R;

public class BaseFragment extends Fragment {

    public AppCompatTextView mTextView;
    private View sRootView;
    private String mTextViewText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        sRootView = inflater.inflate(R.layout.fragment_base, container, false);
        setupViews();

        return sRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mTextViewText = getArguments().getString("fragmentMessage");
        setTextViewText(mTextViewText);
    }

    public void setupViews() {
        mTextView = sRootView.findViewById(R.id.base_fragment_textview);
    }

    public void setTextViewText(String value){
        mTextView.setText(value);
    }

}
