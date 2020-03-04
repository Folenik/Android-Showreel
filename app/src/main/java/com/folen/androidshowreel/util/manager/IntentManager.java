package com.folen.androidshowreel.util.manager;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.folen.androidshowreel.R;
import com.folen.androidshowreel.activity.AutoCompleteEditTextActivity;
import com.folen.androidshowreel.activity.BitmapsActivity;
import com.folen.androidshowreel.activity.BottomNavigationActivity;
import com.folen.androidshowreel.activity.BottomSheetActivity;
import com.folen.androidshowreel.activity.ConfigurationChangesActivity;
import com.folen.androidshowreel.activity.ConstraintLayoutActivity;
import com.folen.androidshowreel.activity.DataBindingActivity;
import com.folen.androidshowreel.activity.DialogsActivity;
import com.folen.androidshowreel.activity.FragmentsActivity;
import com.folen.androidshowreel.activity.FragmentsTransactionActivity;
import com.folen.androidshowreel.activity.IntentDataPassActivity;
import com.folen.androidshowreel.activity.KotlinActivity;
import com.folen.androidshowreel.activity.QRCodeActivity;
import com.folen.androidshowreel.activity.SharedPrefActivity;
import com.folen.androidshowreel.activity.SlidingRegistrationFormActivity;
import com.folen.androidshowreel.activity.SnackBarActivity;
import com.folen.androidshowreel.activity.SpannableActivity;
import com.folen.androidshowreel.activity.TextInputLayoutActivity;
import com.folen.androidshowreel.activity.ViewPagerIndicatorActivity;
import com.folen.androidshowreel.activity.WebViewActivity;
import com.folen.androidshowreel.base.BaseActivity;
import com.folen.androidshowreel.model.Feature;

import org.w3c.dom.Text;

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
                DialogsActivity dialogsActivity = new DialogsActivity();
                return dialogsActivity.intent(activity);
            case 4:
                BottomNavigationActivity bottomNavigationActivity = new BottomNavigationActivity();
                return bottomNavigationActivity.intent(activity);
            case 5:
                BottomSheetActivity bottomSheetActivity = new BottomSheetActivity();
                return bottomSheetActivity.intent(activity);
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
            case 14:
                ViewPagerIndicatorActivity viewPagerIndicatorActivity = new ViewPagerIndicatorActivity();
                return viewPagerIndicatorActivity.intent(activity);
            case 15:
                SlidingRegistrationFormActivity slidingRegistrationFormActivity = new SlidingRegistrationFormActivity();
                return slidingRegistrationFormActivity.intent(activity);
            case 17:
                SnackBarActivity snackBarActivity = new SnackBarActivity();
                return snackBarActivity.intent(activity);
            case 21:
                AutoCompleteEditTextActivity autoCompleteEditTextActivity = new AutoCompleteEditTextActivity();
                return autoCompleteEditTextActivity.intent(activity);
            case 24:
                WebViewActivity webViewActivity = new WebViewActivity();
                return webViewActivity.intent(activity);
            case 25:
                TextInputLayoutActivity textInputLayoutActivity = new TextInputLayoutActivity();
                return textInputLayoutActivity.intent(activity);
            case 29:
                SpannableActivity spannableActivity = new SpannableActivity();
                return spannableActivity.intent(activity);
            case 31:
                SharedPrefActivity sharedPrefActivity = new SharedPrefActivity();
                return sharedPrefActivity.intent(activity);
            case 33:
                KotlinActivity kotlinActivity = new KotlinActivity();
                return kotlinActivity.intent(activity);
            case 34:
                ConfigurationChangesActivity configurationChangesActivity = new ConfigurationChangesActivity();
                return configurationChangesActivity.intent(activity);
            case 36:
                BitmapsActivity bitmapsActivity = new BitmapsActivity();
                return bitmapsActivity.intent(activity);
            case 37:
                DataBindingActivity dataBindingActivity = new DataBindingActivity();
                return dataBindingActivity.intent(activity);
            default:
                return null;
        }
    }
}
