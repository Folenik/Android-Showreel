package com.folen.androidshowreel.util

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.lifecycle.LifecycleObserver
import kotlin.random.Random

class TestService : Service(), LifecycleObserver {

    private lateinit var mHandler: Handler
    private lateinit var mRunnable: Runnable
    private var isRunning: String = "false"

    override fun onBind(intent: Intent?): IBinder? {
        throw UnsupportedOperationException("Not yet implemented.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        isRunning = intent!!.getStringExtra("isRunning")
        mHandler = Handler()
        mRunnable = Runnable {
            if (isRunning == "true") {
                mFunctionForeground()
            } else if (isRunning == "false") {
                mFunctionBackground()
            }
        }
        mHandler.postDelayed(mRunnable, 2500)

        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        mHandler.removeCallbacks(mRunnable)
    }

    private fun mFunctionForeground() {
        val number = Random.nextInt(100)

        Toast.makeText(applicationContext, number.toString(), LENGTH_SHORT).show()
        mHandler.postDelayed(mRunnable, 2500)
    }

    private fun mFunctionBackground() {
        val number = Random.nextInt(100)

        Log.i("Random: ", number.toString())
        mHandler.postDelayed(mRunnable, 2500)
    }
}
