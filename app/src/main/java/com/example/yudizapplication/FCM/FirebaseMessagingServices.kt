package com.example.yudizapplication.FCM

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.example.yudizapplication.R
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import java.io.IOException
import java.net.URL

class FirebaseMessagingServices: FirebaseMessagingService() {
    var TAG = "MyFirebaseMesaggingService"

    override fun onMessageReceived(p0: RemoteMessage) {
        Log.d("VRS","payload size : ${p0.data.size}")
        Log.d("VRS","message : ${p0}")
        if (p0.data.size > 0) {
            Log.d(TAG, "Message Data payload: " + p0.data)
        }
        if (p0.notification != null) {
            sendNotification(
                p0.notification!!.body, p0.notification!!.title, p0.notification!!
                    .imageUrl
            )
        }
    }

    override fun onNewToken(token: String) {
        Log.d(TAG, "Refreshed token: $token")
    }

    private fun sendNotification(messageBody: String?, title: String?, imgUrl: Uri?) {
        val intent = Intent(this, FCMExample::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendingIntent = PendingIntent.getActivity(
            this, 0 , intent,
            PendingIntent.FLAG_IMMUTABLE
        )
        var bmp: Bitmap? = null
        Log.d(TAG, "sendNotification: " + imgUrl.toString())
        try {
            val `in` = URL(imgUrl.toString()).openStream()
            bmp = BitmapFactory.decodeStream(`in`)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        val channelId = getString(R.string.default_notification_channel_id)
        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val notificationBuilder: NotificationCompat.Builder =
            NotificationCompat.Builder(this, channelId)
                .setSmallIcon(R.drawable.img)
                .setContentTitle(title)
                .setContentText(messageBody)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent)
                .setStyle(NotificationCompat.BigPictureStyle().bigPicture(bmp))
                .setPriority(Notification.PRIORITY_HIGH)
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                "Channel human readable title",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationManager.createNotificationChannel(channel)
        }
        notificationManager.notify(0, notificationBuilder.build())
    }
}