package com.example.yudizapplication.FCM

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.yudizapplication.R
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.google.firebase.messaging.remoteMessage

const val channelId = "notification_channel"
const val channelName = "com.example.yudizapplication.FCM"
class MyFirebaseMessagingServices : FirebaseMessagingService() {

 fun generateNotification(title : String, message: String) {

     val intent = Intent(this, FCMExample::class.java)
     intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

     val pendingIntent = PendingIntent.getActivity(
         this, 0, intent,
         PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_MUTABLE
     )

     var builder: NotificationCompat.Builder =
         NotificationCompat.Builder(applicationContext, channelId)
             .setSmallIcon(R.drawable.img)
             .setAutoCancel(true)
             .setVibrate(longArrayOf(1000, 1000, 1000, 1000))
             .setOnlyAlertOnce(true)
             .setContentIntent(pendingIntent)

     builder = builder.setContent(getRemoteView(title, message))

     val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

     notificationManager.notify(0,builder.build())
 }
//
//    override fun onMessageReceived(message: RemoteMessage) {
//        if (remoteMessage.getNotification() != null)
//        {
//            generateNotification(remoteMessage.notification!!.title!!, remoteMessage.notification!!.body!!)
//        }
//    }

    private fun getRemoteView(title: String, message: String): RemoteViews? {
        val remoteViews = RemoteViews("com.example.yudizsolution.fcm",R.layout.notification)

        remoteViews.setTextViewText(R.id.title,title)
        remoteViews.setTextViewText(R.id.message,message)
        remoteViews.setImageViewResource(R.id.icon,R.drawable.img)

        return remoteViews
    }
}