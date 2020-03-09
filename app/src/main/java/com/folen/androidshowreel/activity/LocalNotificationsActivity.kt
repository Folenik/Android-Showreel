package com.folen.androidshowreel.activity

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.folen.androidshowreel.R
import com.folen.androidshowreel.util.Const.*
import com.folen.androidshowreel.util.NotificationReceiver


lateinit var notificationManager: NotificationManagerCompat
lateinit var myBitmapIcon: Bitmap
lateinit var myCharSequence: CharSequence

class LocalNotificationsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_local_notifications)

        init()
    }

    private fun init() {
        notificationManager = NotificationManagerCompat.from(this)
        myBitmapIcon = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.flower)
    }

    @Suppress("UNUSED_PARAMETER")
    fun createAndShowSimpleNotification(view: View) {
        val notification = NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_notifications)
                .setContentTitle("Simple notification.")
                .setContentText("It's with low priority.")
                .build()

        notificationManager.notify(1, notification)
    }

    @Suppress("UNUSED_PARAMETER")
    fun createAndShowCustomNotification(view: View) {
        val notification = NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_notifications)
                .setContentTitle("Custom notification.")
                .setContentText("It has image and onclick expand description.")
                .setLargeIcon(myBitmapIcon)
                .setStyle(NotificationCompat.BigPictureStyle()
                        .bigPicture(myBitmapIcon)
                        .bigLargeIcon(null))
                .setOnlyAlertOnce(true)
                .build()

        notificationManager.notify(2, notification)
    }

    @Suppress("UNUSED_PARAMETER")
    fun createAndShowActionNotification(view: View) {
        val broadcastIntent = Intent(this, NotificationReceiver::class.java)
        broadcastIntent.putExtra("restart", "You can now open your application again.")

        val actionIntent = PendingIntent.getBroadcast(this,
                0, broadcastIntent, PendingIntent.FLAG_UPDATE_CURRENT)

        val notification = NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_notifications)
                .setContentTitle("Action notification.")
                .setContentText("Application restart is required.")
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .addAction(R.mipmap.ic_launcher, "Restart app", actionIntent)
                .build()

        notificationManager.notify(3, notification)
    }

    fun intent(context: Context): Intent {
        return Intent(context, LocalNotificationsActivity::class.java)
    }
}