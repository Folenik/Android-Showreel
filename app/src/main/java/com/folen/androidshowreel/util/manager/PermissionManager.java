package com.folen.androidshowreel.util.manager;

import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import com.folen.androidshowreel.base.BaseActivity;

public class PermissionManager {

    public static boolean isGranted(BaseActivity activity, @NonNull String permission) {
        return ContextCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_GRANTED;
    }

    public static boolean hasBeenDenied(BaseActivity activity, @NonNull String permission) {
        return ActivityCompat.shouldShowRequestPermissionRationale(activity, permission);
    }

    public static void requestPermission(BaseActivity activity, @NonNull String permission, int requestCode) {
        ActivityCompat.requestPermissions(activity, new String[]{permission}, requestCode);
    }
}
