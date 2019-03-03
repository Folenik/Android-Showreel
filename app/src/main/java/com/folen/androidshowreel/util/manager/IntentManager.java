package com.folen.androidshowreel.util.manager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.folen.androidshowreel.R;
import com.folen.androidshowreel.activity.QRCodeActivity;
import com.folen.androidshowreel.base.BaseActivity;
import com.folen.androidshowreel.model.Feature;

public class IntentManager {

    @SuppressLint("MissingPermission")
    @Nullable
    public static Intent getIntentForFeature(BaseActivity context, Feature feature) {
        switch (feature.getId()) {
            case 0:
                //TODO
                Toast.makeText(context, context.getString(R.string.error_not_implemented), Toast.LENGTH_SHORT).show();
            case 1:
                //TODO
                Toast.makeText(context, context.getString(R.string.error_not_implemented), Toast.LENGTH_SHORT).show();
            case 2:
                //TODO
                Toast.makeText(context, context.getString(R.string.error_not_implemented), Toast.LENGTH_SHORT).show();
            case 3:
                //TODO
                Toast.makeText(context, context.getString(R.string.error_not_implemented), Toast.LENGTH_SHORT).show();
            case 4:
                //TODO
                Toast.makeText(context, context.getString(R.string.error_not_implemented), Toast.LENGTH_SHORT).show();
            case 5:
                //TODO
                Toast.makeText(context, context.getString(R.string.error_not_implemented), Toast.LENGTH_SHORT).show();
            case 6:
                //TODO
                Toast.makeText(context, context.getString(R.string.error_not_implemented), Toast.LENGTH_SHORT).show();
            case 7:
                //TODO
                Toast.makeText(context, context.getString(R.string.error_not_implemented), Toast.LENGTH_SHORT).show();
            case 8:
                return QRCodeActivity.intent(context);
            default:
                return null;
        }
    }
}
