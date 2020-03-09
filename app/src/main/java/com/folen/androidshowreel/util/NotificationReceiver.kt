package com.folen.androidshowreel.util

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class NotificationReceiver: BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {
        val extra = intent?.getStringExtra("restart")
        Toast.makeText(context,extra,Toast.LENGTH_SHORT).show()

        val i = Intent()
        i.setClassName("com.folen", "com.folen.androidshowreel.activity.CloseAppActivity")
        i.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context!!.startActivity(i)
    }
}