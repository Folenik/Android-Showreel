package com.folen.androidshowreel.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    private AlertDialog alertDialog;

    public void showDialog(AlertDialog alertDialog) {
        this.alertDialog = alertDialog;
        this.alertDialog.show();
    }

    public void hideDialog() {
        this.alertDialog.hide();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        alertDialog = new AlertDialog.Builder(this).create();
    }

    @Override
    protected void onDestroy() {
        alertDialog.dismiss();
        alertDialog = null;
        super.onDestroy();
    }
}
