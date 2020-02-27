package com.folen.androidshowreel.util.manager;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.folen.androidshowreel.R;
import com.folen.androidshowreel.activity.ConfigurationChangesActivity;
import com.folen.androidshowreel.activity.ConstraintLayoutActivity;
import com.folen.androidshowreel.activity.DataBindingActivity;
import com.folen.androidshowreel.activity.FragmentsActivity;
import com.folen.androidshowreel.activity.FragmentsTransactionActivity;
import com.folen.androidshowreel.activity.IntentDataPassActivity;
import com.folen.androidshowreel.activity.KotlinActivity;
import com.folen.androidshowreel.activity.QRCodeActivity;
import com.folen.androidshowreel.activity.SharedPrefActivity;
import com.folen.androidshowreel.base.BaseActivity;
import com.folen.androidshowreel.model.Feature;

import static com.folen.androidshowreel.util.Const.REQUEST_CODE_QR_SCANNER;

public class IntentManager {

    @SuppressLint("MissingPermission")
    @Nullable
    public static Intent getIntentForFeature(BaseActivity context, Feature feature) {
        return getIntentForId(context, feature.getId());
    }


    @SuppressLint("MissingPermission")
    @Nullable
    public static Intent getIntentForId(BaseActivity activity, Integer featureId) {
        switch (featureId) {
            case 0:
                return ConstraintLayoutActivity.intent(activity);
            case 1:
                //TODO
                Toast.makeText(activity, activity.getString(R.string.error_not_implemented), Toast.LENGTH_SHORT).show();
            case 2:
                FragmentsActivity fragmentsActivity = new FragmentsActivity();
                return fragmentsActivity.intent(activity);
            case 3:
                //TODO
                Toast.makeText(activity, activity.getString(R.string.error_not_implemented), Toast.LENGTH_SHORT).show();
            case 4:
                //TODO
                Toast.makeText(activity, activity.getString(R.string.error_not_implemented), Toast.LENGTH_SHORT).show();
            case 5:
                //TODO
                Toast.makeText(activity, activity.getString(R.string.error_not_implemented), Toast.LENGTH_SHORT).show();
            case 6:
                //TODO
                Toast.makeText(activity, activity.getString(R.string.error_not_implemented), Toast.LENGTH_SHORT).show();
            case 7:
                //TODO
                Toast.makeText(activity, activity.getString(R.string.error_not_implemented), Toast.LENGTH_SHORT).show();
            case 8:
                if (PermissionManager.isGranted(activity, Manifest.permission.CAMERA)) {
                    return QRCodeActivity.intent(activity);
                } else {
                    if (PermissionManager.hasBeenDenied(activity, Manifest.permission.CAMERA)) {
                        DialogManager.showDialog(activity,
                                R.string.error_permission_rationale_camera_title,
                                R.string.error_permission_rationale_camera_description,
                                R.string.error_permission_rationale_camera_accept_button,
                                (dialog, which) -> {
                                    Intent intent = new Intent();
                                    intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                    Uri uri = Uri.fromParts("package", activity.getPackageName(), null);
                                    intent.setData(uri);
                                    activity.startActivity(intent);
                                });
                    } else {
                        PermissionManager.requestPermission(activity, Manifest.permission.CAMERA, REQUEST_CODE_QR_SCANNER);
                    }
                }
            case 9:
                IntentDataPassActivity intentDataPassActivity = new IntentDataPassActivity();
                return intentDataPassActivity.intent(activity);
            case 13:
                FragmentsTransactionActivity fragmentsTransactionActivity = new FragmentsTransactionActivity();
                return fragmentsTransactionActivity.intent(activity);
            case 31:
                SharedPrefActivity sharedPrefActivity = new SharedPrefActivity();
                return sharedPrefActivity.intent(activity);
            case 33:
                KotlinActivity kotlinActivity = new KotlinActivity();
                return kotlinActivity.intent(activity);
            case 34:
                ConfigurationChangesActivity configurationChangesActivity = new ConfigurationChangesActivity();
                return configurationChangesActivity.intent(activity);
            case 37:
                DataBindingActivity dataBindingActivity = new DataBindingActivity();
                return dataBindingActivity.intent(activity);
            default:
                return null;
        }
    }
}
