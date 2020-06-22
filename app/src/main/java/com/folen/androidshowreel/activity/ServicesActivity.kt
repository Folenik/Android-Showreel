package com.folen.androidshowreel.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.AppCompatActivity
import com.folen.androidshowreel.R
import com.folen.androidshowreel.util.TestService

class ServicesActivity : AppCompatActivity() {

    private lateinit var serviceClass: Class<TestService>
    private lateinit var mIntent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_services)

        initService()
    }

    private fun initService() {
        serviceClass = TestService::class.java
        mIntent = Intent(applicationContext, serviceClass)
        mIntent.putExtra("isRunning", "true")
    }

    override fun onPause() {
        super.onPause()
        mIntent.putExtra("isRunning", "false")
        startService(mIntent)
    }

    override fun onResume() {
        super.onResume()
        mIntent.putExtra("isRunning", "true")
        startService(mIntent)
    }

    fun intent(context: Context): Intent {
        return Intent(context, ServicesActivity::class.java)
    }

    @SuppressWarnings("UNUSED_PARAMETER")
    fun startService(view: View) {
        startService(mIntent)
        Toast.makeText(applicationContext, "Start", LENGTH_SHORT).show()
    }

    @SuppressWarnings("UNUSED_PARAMETER")
    fun stopService(view: View) {
        stopService(mIntent)
        Toast.makeText(applicationContext, "Stop", LENGTH_SHORT).show()
    }
}