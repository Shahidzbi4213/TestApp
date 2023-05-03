package com.test.interview.data.alarm

import com.test.interview.data.model.AlarmItem

interface AlarmScheduler {

    fun schedule(item: AlarmItem)

    fun cancel(item: AlarmItem)
}