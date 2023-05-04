package com.test.interview.data.alarm

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.test.interview.R
import com.test.interview.utils.NotificationsUtils

/*
 * Created by Shahid Iqbal on 5/3/2023.
 */

class AlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        intent?.let {
            val title = it.getStringExtra("EXTRA_TITLE") ?: "Title"
            val message = it.getStringExtra("EXTRA_MESSAGE") ?: "Body of Notification"
            val day = it.getStringExtra("EXTRA_DAY") ?: "Undefined"

            context?.showNotification(title, message, day)
        }
    }


    @SuppressLint("MissingPermission")
    fun Context.showNotification(title: String, message: String, day: String) {
        val builder = NotificationCompat.Builder(this, getString(R.string.channel_id))
            .setSmallIcon(R.drawable.ic_book)
            .setContentTitle(title)
            .setContentText("$message is $day")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)


        NotificationsUtils.startNotification(this, 1122, builder)
    }
}