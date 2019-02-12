package com.folen.androidshowreel;

import android.app.Application;
import android.util.Log;

public class ShowreelApp extends Application {

    private static final String TAG = ShowreelApp.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "Application initialized");
    }
}
