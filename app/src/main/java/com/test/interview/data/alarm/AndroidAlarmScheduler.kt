package com.test.interview.data.alarm

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import com.test.interview.data.model.AlarmItem
import java.util.Calendar

/*
 * Created by Shahid Iqbal on 5/3/2023.
 */

class AndroidAlarmScheduler(
    private val context: Context
) : AlarmScheduler {

    private val alarmManager = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        context.getSystemService(AlarmManager::class.java)
    } else {
        context.getSystemService(Context.ALARM_SERVICE) as? AlarmManager
    }


    override fun schedule(item: AlarmItem) {

        val intent = Intent(context, AlarmReceiver::class.java).apply {
            putExtra("EXTRA_TITLE", item.title)
            putExtra("EXTRA_MESSAGE", item.body)
            putExtra("EXTRA_DAY", item.day)
        }

        val time = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 12)
            set(Calendar.MINUTE, 0)
        }

        alarmManager?.setRepeating(
            AlarmManager.RTC_WAKEUP,
            time.timeInMillis,
            AlarmManager.INTERVAL_DAY,
            PendingIntent.getBroadcast(
                context,
                item.hashCode(),
                intent,
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_IMMUTABLE else 0
            )
        )

    }

    override fun cancel(item: AlarmItem) {
        val intent = Intent(context, AlarmReceiver::class.java)
        alarmManager?.cancel(
            PendingIntent.getBroadcast(
                context,
                item.hashCode(),
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )
        )
    }

}