package com.test.interview.utils

import android.annotation.SuppressLint
import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

object NotificationsUtils {

    @SuppressLint("MissingPermission")
    fun startNotification(context: Context, id: Int, builder: NotificationCompat.Builder) {
        with(NotificationManagerCompat.from(context)) {
            notify(id, builder.build())
        }
    }

    fun cancelNotification(context: Context, id: Int) {
        with(NotificationManagerCompat.from(context)) {
            cancel(id)
        }
    }
}