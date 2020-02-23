package com.folen.androidshowreel.util.manager;

import android.content.DialogInterface;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;

import com.folen.androidshowreel.R;
import com.folen.androidshowreel.base.BaseActivity;

public class DialogManager {

    public static void showDialog(BaseActivity activity, @StringRes int titleRes, @StringRes int descriptionRes, @StringRes int acceptButtonTextRes, DialogInterface.OnClickListener acceptClickAction) {
        activity.showDialog(new AlertDialog.Builder(activity)
                .setTitle(titleRes)
                .setMessage(descriptionRes)
                .setCancelable(false)
                .setNegativeButton(R.string.cancel, (dialog, which) -> {
                    activity.hideDialog();
                })
                .setPositiveButton(acceptButtonTextRes, acceptClickAction)
                .create());
    }

    public static void showFinishDialog(BaseActivity activity, @StringRes int titleRes, @StringRes int descriptionRes) {
        activity.showDialog(new AlertDialog.Builder(activity)
                .setTitle(titleRes)
                .setMessage(descriptionRes)
                .setCancelable(false)
                .setPositiveButton(R.string.ok, (dialog, which) -> {
                    activity.finish();
                })
                .create());
    }
}
