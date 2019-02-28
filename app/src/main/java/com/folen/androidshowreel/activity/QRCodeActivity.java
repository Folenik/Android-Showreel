package com.folen.androidshowreel.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.folen.androidshowreel.R;
import com.folen.androidshowreel.base.BaseActivity;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class QRCodeActivity extends BaseActivity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView mScannerView;
    private FrameLayout sContentFrame;
    private Toolbar mToolbar;
    private AppCompatTextView mQRTextView;

    @Override
    protected void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_qr_scanner);

        setupViews();
    }

    public static Intent intent(Context context) {
        return new Intent(context, QRCodeActivity.class);
    }

    public void setupViews() {
        sContentFrame = findViewById(R.id.qr_content);
        mToolbar = findViewById(R.id.qr_toolbar);
        mQRTextView = findViewById(R.id.qr_textview);

        mScannerView = new ZXingScannerView(this);
        sContentFrame.addView(mScannerView);
        mToolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        mToolbar.setTitle(R.string.qr_feature_name);
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    public void onPause() {
        mScannerView.stopCamera();
        super.onPause();
    }

    @Override
    public void handleResult(Result rawResult) {
        mQRTextView.setText(getString(R.string.qr_code) + rawResult.getText());
        mScannerView.resumeCameraPreview(this);
    }
}

