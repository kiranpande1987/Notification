package com.kprights.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat.getSystemService


class NotificationReceiver : BroadcastReceiver() {
    private val channelId = "CHANNEL_ID"
    private val title = "Notification Title"
    private val content = "This is notification content"

    override fun onReceive(context: Context, intent: Intent) {
        Log.e("NotificationReceiver", "onReceive called")

        showAppNotification(context, intent)
    }

    private fun showAppNotification(context: Context, intent: Intent){
        val builder = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(title)
            .setContentText(content)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Channel name"
            val descriptionText = "Channel description"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(channelId, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
            NotificationManagerCompat.from(context).notify(1234, builder.build())

        }
    }
}