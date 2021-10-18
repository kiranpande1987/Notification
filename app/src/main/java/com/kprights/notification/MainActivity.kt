package com.kprights.notification

import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.sendNotification).setOnClickListener {
            val intent = Intent()
            intent.action = "com.kprights.notification.APP_NOTIFICATION"
            intent.component = ComponentName("com.kprights.notification",
                    "com.kprights.notification.NotificationReceiver")
            sendBroadcast(intent)
        }
    }
}