package com.folen.androidshowreel.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.folen.androidshowreel.R;
import com.folen.androidshowreel.base.BaseActivity;

public class ConstraintLayoutActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint);
    }

    public static Intent intent(Context context) {
        return new Intent(context, ConstraintLayoutActivity.class);
    }
}
