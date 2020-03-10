package com.folen.androidshowreel.activity

import android.Manifest
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.appcompat.app.AppCompatActivity
import com.folen.androidshowreel.R
import com.nabinbhandari.android.permissions.PermissionHandler
import com.nabinbhandari.android.permissions.Permissions

class LivePermissionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_permissions)
    }

    @Suppress("UNUSED_PARAMETER")
    fun askForPermissions(view: View) {
        val permissions = arrayOf<String>(
                Manifest.permission.CAMERA,
                Manifest.permission.RECORD_AUDIO,
                Manifest.permission.BODY_SENSORS,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.READ_CALENDAR)
        Permissions.check(this, permissions, null, null, object : PermissionHandler() {
            override fun onGranted() {
                openActivity(true)
            }

            override fun onDenied(context: Context?, deniedPermissions: ArrayList<String?>?) {
                openActivity(false)
            }
        })
    }

    private fun openActivity(isGranted: Boolean) {
        if (isGranted) {
            val intent = Intent(this, KotlinActivity::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(this, "Not all permissions are granted.", LENGTH_LONG).show()
        }
    }

    fun intent(context: Context): Intent {
        return Intent(context, LivePermissionsActivity::class.java)
    }
}