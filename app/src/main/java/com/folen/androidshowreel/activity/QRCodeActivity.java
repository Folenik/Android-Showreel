package com.folen.androidshowreel.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.RequiresPermission;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.folen.androidshowreel.R;
import com.folen.androidshowreel.base.BaseActivity;
import com.folen.androidshowreel.util.manager.DialogManager;
import com.folen.androidshowreel.util.manager.PermissionManager;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class QRCodeActivity extends BaseActivity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView mScannerView;
    private AppCompatTextView mQRTextView;

    @Override
    protected void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_qr_scanner);

        setupViews();
    }

    @RequiresPermission(value = CAMERA_SERVICE)
    public static Intent intent(Context context) {
        return new Intent(context, QRCodeActivity.class);
    }

    public void setupViews() {
        FrameLayout sContentFrame = findViewById(R.id.qr_content);
        Toolbar mToolbar = findViewById(R.id.qr_toolbar);
        mQRTextView = findViewById(R.id.qr_textview);

        mScannerView = new ZXingScannerView(this);
        sContentFrame.addView(mScannerView);
        mToolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        mToolbar.setTitle(R.string.qr_feature_name);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (PermissionManager.isGranted(this, Manifest.permission.CAMERA)) {
            mScannerView.setResultHandler(this);
            mScannerView.startCamera();
        } else {
            DialogManager.showFinishDialog(this,
                    R.string.error_permission_rationale_camera_title,
                    R.string.error_permission_rationale_camera_description);
        }
    }

    @Override
    public void onPause() {
        mScannerView.stopCamera();
        super.onPause();
    }

    @Override
    public void handleResult(Result rawResult) {
        mQRTextView.setText(getString(R.string.qr_code, rawResult.getText()));
        mScannerView.resumeCameraPreview(this);
    }
}

