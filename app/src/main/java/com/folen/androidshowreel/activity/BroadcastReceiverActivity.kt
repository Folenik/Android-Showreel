package com.folen.androidshowreel.activity

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.appcompat.app.AppCompatActivity
import com.folen.androidshowreel.R

class BroadcastReceiverActivity : AppCompatActivity() {

    private val filter = IntentFilter()
    private lateinit var broadCastReceiver: BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broadcast_receiver)

        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        broadCastReceiver = object : BroadcastReceiver() {
            override fun onReceive(contxt: Context?, intent: Intent?) {
                Toast.makeText(applicationContext, getString(R.string.airplane_mode), LENGTH_LONG).show()
            }
        }
        registerReceiver(broadCastReceiver, filter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(broadCastReceiver)
    }

    override fun onResume() {
        super.onResume()
        registerReceiver(broadCastReceiver, filter)
    }

    fun intent(context: Context): Intent {
        return Intent(context, BroadcastReceiverActivity::class.java)
    }
}