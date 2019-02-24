package com.folen.androidshowreel.util.manager;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.folen.androidshowreel.R;
import com.folen.androidshowreel.activity.ConstraintLayoutActivity;
import com.folen.androidshowreel.activity.FragmentActivity;
import com.folen.androidshowreel.activity.QRCodeActivity;
import com.folen.androidshowreel.model.Feature;

public class IntentManager {

    @Nullable
    public static Intent getIntentForFeature(Context context, Feature feature) {
        switch (feature.getId()) {
            case 0:
                return ConstraintLayoutActivity.intent(context);
            case 1:
                //TODO
                Toast.makeText(context, context.getString(R.string.error_not_implemented), Toast.LENGTH_SHORT).show();
            case 2:
                return FragmentActivity.intent(context);
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
                //TODO
                return QRCodeActivity.intent(context);
            default:
                return null;
        }
    }
}
