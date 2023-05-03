package com.test.interview.data.custom_notification

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.test.interview.R
import com.test.interview.utils.NotificationsUtils

/*
 * Created by Shahid Iqbal on 5/4/2023.
 */

@SuppressLint("MissingPermission")
fun Context.createCustomNotification() {
    val builder = NotificationCompat.Builder(this, getString(R.string.channel_id))
        .setSmallIcon(R.drawable.ic_ramazan)
        .setContentTitle("Happy Ramazan")
        .addAction(
            android.R.drawable.ic_media_play, "Play", pendingActionTask(this, 1)
        )
        .addAction(
            android.R.drawable.ic_menu_close_clear_cancel, "Cancel", pendingActionTask(this, 0)
        )
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)

    NotificationsUtils.startNotification(context = this, 4433, builder)


}

fun pendingActionTask(context: Context, playStatus: Int): PendingIntent {
    println(playStatus)

    val intent = Intent(context, CustomNotificationReceiver::class.java).apply {
        putExtra("PLAY_ME", playStatus.toString())
    }
    return PendingIntent.getBroadcast(
        context, playStatus, intent,
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_IMMUTABLE else 0
    )
}
