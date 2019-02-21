package com.folen.androidshowreel.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.widget.Toast;

import com.folen.androidshowreel.R;
import com.folen.androidshowreel.base.BaseActivity;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class QRCodeActivity extends BaseActivity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView mScannerView;
    private SharedPreferences mScannerPreference;
    private SharedPreferences.Editor mScannerPreferenceEditor;
    private ViewGroup contentFrame;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_qr_scanner);

        Bindings();
        setupScannerAndToolbar();
        retrieveScannedCode();
    }

    public static Intent intent(Context context) {
        return new Intent(context, QRCodeActivity.class);
    }

    public void Bindings() {
        contentFrame = findViewById(R.id.qr_content);
        toolbar = findViewById(R.id.qr_toolbar);
    }

    public void setupScannerAndToolbar() {
        mScannerView = new ZXingScannerView(this);
        contentFrame.addView(mScannerView);
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
    }

    public void retrieveScannedCode() {
        mScannerPreference = getApplicationContext().getSharedPreferences("QR Code Value", 0);
        mScannerPreferenceEditor = mScannerPreference.edit();

        if (mScannerPreference.getString("qr_value", null) != null) {
            toolbar.setTitle("QR CODE: " + mScannerPreference.getString("qr_value", null));
        }
        else {
            toolbar.setTitle("QR CODE never scanned");
        }
    }

        @Override
        public void onResume () {
            super.onResume();
            mScannerView.setResultHandler(this);
            mScannerView.startCamera();
        }

        @Override
        public void onPause () {
            super.onPause();
            mScannerView.stopCamera();
        }

        @Override
        public void handleResult (Result rawResult){
            Toast.makeText(getApplicationContext(), "Done!", Toast.LENGTH_SHORT).show();
            mScannerPreferenceEditor.putString("qr_value", rawResult.getText());
            mScannerPreferenceEditor.commit();
            toolbar.setTitle("QR CODE: " + mScannerPreference.getString("qr_value", null));
            mScannerView.resumeCameraPreview(this);
        }
    }

