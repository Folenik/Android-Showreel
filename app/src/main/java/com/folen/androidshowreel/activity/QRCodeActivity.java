package com.folen.androidshowreel.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.folen.androidshowreel.R;
import com.folen.androidshowreel.base.BaseActivity;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;
import static com.folen.androidshowreel.util.Const.QR_CODE_NAME;
import static com.folen.androidshowreel.util.Const.QR_CODE_NEVER_SCANNED;

public class QRCodeActivity extends BaseActivity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView mScannerView;
    private FrameLayout contentFrame;
    private Toolbar toolbar;

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
        contentFrame = findViewById(R.id.qr_content);
        toolbar = findViewById(R.id.qr_toolbar);

        mScannerView = new ZXingScannerView(this);
        contentFrame.addView(mScannerView);
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        toolbar.setTitle(QR_CODE_NEVER_SCANNED);
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
        toolbar.setTitle(QR_CODE_NAME + rawResult.getText());
        mScannerView.resumeCameraPreview(this);
    }
}

