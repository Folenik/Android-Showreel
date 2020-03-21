package com.folen.androidshowreel.activity

import android.Manifest
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.folen.androidshowreel.R
import com.folen.androidshowreel.util.Const.APP_TAG
import com.folen.androidshowreel.util.Const.GET_PHOTO_REQUEST_CODE
import com.nabinbhandari.android.permissions.PermissionHandler
import com.nabinbhandari.android.permissions.Permissions
import kotlinx.android.synthetic.main.activity_load_image.*

class LoadImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load_image)

        checkForPermissions()
    }

    private fun checkForPermissions() {
        val permissions = arrayOf(
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)

        Permissions.check(this, permissions, null, null, object : PermissionHandler() {
            override fun onGranted() {
                Log.d(APP_TAG, getString(R.string.ok))
            }

            override fun onDenied(context: Context?, deniedPermissions: ArrayList<String?>?) {
                val builder = AlertDialog.Builder(this@LoadImageActivity)
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

    @Suppress("UNUSED_PARAMETER")
    fun loadImage(view: View) {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
        if (intent.resolveActivity(packageManager) != null) {
            startActivityForResult(intent, GET_PHOTO_REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == GET_PHOTO_REQUEST_CODE && data != null) {
            val photoUri = data.data
            val selectedImage = MediaStore.Images.Media.getBitmap(this.contentResolver, photoUri)
            load_imageView.setImageBitmap(selectedImage)
        }
    }

    fun intent(context: Context): Intent {
        return Intent(context, LoadImageActivity::class.java)
    }
}