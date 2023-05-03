package com.test.interview.presentation.favourite

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.test.interview.data.model.AlarmItem
import com.test.interview.data.alarm.AndroidAlarmScheduler

/*
 * Created by Shahid Iqbal on 5/3/2023.
 */

class FavViewModel(private val application: Application) : AndroidViewModel(application) {

    private val scheduler = AndroidAlarmScheduler(application.applicationContext)

    fun startAlarm(item: AlarmItem) {
        scheduler.schedule(item)
    }

    fun cancel(item: AlarmItem) {
        scheduler.cancel(item)
    }
}