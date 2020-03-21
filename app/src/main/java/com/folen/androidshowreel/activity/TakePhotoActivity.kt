package com.folen.androidshowreel.activity

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import com.folen.androidshowreel.R
import com.folen.androidshowreel.util.Const.APP_TAG
import com.folen.androidshowreel.util.Const.CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE
import com.nabinbhandari.android.permissions.PermissionHandler
import com.nabinbhandari.android.permissions.Permissions
import java.io.File

class TakePhotoActivity : AppCompatActivity() {

    private lateinit var photoFile: File

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_take_photo)
    }

    override fun onStart() {
        super.onStart()
        checkForPermissions()
    }

    private fun checkForPermissions() {
        val permissions = arrayOf(
                Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)

        Permissions.check(this, permissions, null, null, object : PermissionHandler() {
            override fun onGranted() {
                startCamera()
            }

            override fun onDenied(context: Context?, deniedPermissions: ArrayList<String?>?) {
                val builder = AlertDialog.Builder(this@TakePhotoActivity)
                with(builder) {
                    setTitle(getString(R.string.error_permission_rationale_title))
                    setMessage(getString(R.string.error_permission_rationale_description))
                    setCancelable(false)
                    setPositiveButton(getString(R.string.error_permission_rationale_accept_button)) { _, _ ->
                        finish()
                    }
                    show()
                }
            }
        })
    }

    private fun startCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        photoFile = getPhotoFileUri("photo" + System.currentTimeMillis() + ".png");
        val fileProvider: Uri = FileProvider.getUriForFile(this, "com.folen.androidshowreel.activity", photoFile);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileProvider);

        if (intent.resolveActivity(packageManager) != null) {
            startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
        }
    }

    private fun getPhotoFileUri(fileName: String): File {
        val mediaStorageDir = File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), APP_TAG)

        if (!mediaStorageDir.exists() && !mediaStorageDir.mkdirs()) {
            Log.d(APP_TAG, getString(R.string.error_failed_directory))
        }
        return File(mediaStorageDir.path + File.separator + fileName)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                Toast.makeText(this, getString(R.string.picture_taken, photoFile.path.toString()), Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, getString(R.string.picture_not_taken), Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun intent(context: Context): Intent {
        return Intent(context, TakePhotoActivity::class.java)
    }
}